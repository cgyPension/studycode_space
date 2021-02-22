/*
  clickhouse 是c++写的 列式存储 查某一列数据特别快 查所有列的数据还是行式的比较快

   采用LSM Tree的结构 不支持开窗函数

   Hbase会按照rowkey进行排序

   利弊：
   clickhouse可以将数据划分为多分区；会对单条查询都能利用整机所有cpu，极致的并行能力
   降低了查询延时，对于大数据量的查询也能化整为零平行处理。
   但是有一个弊端对于单条查询使用多cpu，就不利于同时并发多条查询，对于高qps（每秒响应请求数）
   的查询业务，clickhouse并不是强项。

   限制：
   1. 没有完整的事务支持。
   2. 缺少高频率,低延迟的修改或删除已存在数据的能力。仅能用于批量删除或修改数据,但这符合GDPR
   3. 稀疏索引(不是每个主键都建索引，[10-20]..[50-60]，
   使用很少的索引数据，定位更多的数据，代价就是只能定位到索引粒度的第一行，然后再进行一点扫描
   ，由于稀疏索引很少理论上可以完全加载到内存中，提高查询速度
   ) 使得ClickHouse不适合通过其键检索单行的点查询

   数据类型：
   Int
   有符号（包含正负数）
   无符号（0~正无穷）

   Float32 - float
   Float64 - double

   没有布尔类型
   可以用UInt8，取值限制为 0 或 1

   字符串
   String 可以任意长度的，可以包含任意的字节集
   Fixedstring(N) 固定长度N的字符串，N必须是严格的正自然数；
   当服务端读取长度小于N的字符串时候，通过在字符串末尾添加空字节来达到N字节长度；
   当服务端读取长度大于N的字符串时候，将返回错误信息，极少使用

   枚举类 对一些状态、类型的字段算是一种空间优化，也算是一种数据约束。
   但是实际使用中往往因为一些数据内容的变化增加一定的维护成本，甚至是数据丢失问题，谨慎使用

   时间类型：
   Date 接受年-月-日 的字符串比如 '2019-12-16'
   Datetime 接受年月日时:分:秒的字符串比如 '2019-12-16 20:10:10'
   Daterime64 接受年月-日时:分:秒亚秒的字符串比如 '2019-12-16 20:50:10.66'

   数组：
   Array(T): 由T类型元素组成的数组,T可以是任意类型,包含数组类型。
   但不推荐使用多维数组, ClickHouse对多维数组的支持有限。例如,不能在MergeTree表中存储多维数组。

   表引擎（都是大写开头）：
   Tinylog
   以列文件的形式保存在磁盘上,不支持索引,没有并发控制。一殷保存少量数据的小表,生产环境上作用有限。
   可以用于平时练习测试用。

   Memory
   内存引擎 重启clickhouse后数据会丢失 暂时还不能替代redis

   MergeTree
   必须有排序，分区、主键（必须是order by里的字段）也要尽量有
   index granularity索引粒度，在MergeTree中默认是8192，官方不建议修改这个值
    （显示出分区的时候有时候不准，因为是LSM 你不知道他什么时候合并，新插入的数据会进入一个临时分区，
    写入后大概（10-15分钟后），clickhouse会自动执行合并操作（等不急也可以手动执行optimize执行，
    把临时分区数据，合并到已有分区中。optimize table 表名 final）
    ）

    ReplacingMergeTree(ver)
    只能分区内去重，去重的时间不确定，只有在合并的时候会去重。
    适用于在后台清除重复的数据以节省空间，但是它 不保证没有重复 的数据出现.
    ver：版本；在进行数据合并时，从所有具有相同排序键的行中选择一行留下，
    如果ver列未指定，保留最后一条
    如果ver列已指定，保留ver值最大的版本

    SummingMergeTree
    对于不查询明细，只关心以维度进行汇总聚合结果的场景。分区内聚合
    如果只使用普通的MergeTree，无论是存储空间的开销，还是查询时聚合的开销都比较大
    对指定的字段进行聚合，按照order by里的维度进行聚合
    clickhouse的order by 有点像传统sql 加上group by的功能


    TTl
    可以设置某一列、某一张表过期时间

    复本(高可用):
	副本的目的主要是保障数据的高可用性，即使一台clickhouse节点宕机，那么也可以从其他服务器获得相同的数据。
	clickhouse的副本严重依赖zookeeper(不同节点的clickhouse不能直接通信，要通过zookeeper), 用于通知副本server状态变更
	副本是表级别的，不是整个服务器级的。所以，服务器里可以同时有复本表和非复本表。

	clickhouse的复本是表级别的. 有些语句不会自动产生复本, 有些语句会自动产生复本
    对于 INSERT 和 ALTER 语句操作数据会在压缩的情况下被复制
    而 CREATE，DROP，ATTACH，DETACH 和 RENAME 语句只会在单个服务器上执行，不会被复制
    所以建表的时候, 需要在2个节点上分别手动建表（配置文件建立宏就可以不用）
    需要用到一个 重复引擎 ReplicatedMergeTree

在hadoop102建表
create table rep_t_order_mt2020 (
    id UInt32,
    sku_id String,
    total_amount Decimal(16,2),
    create_time  Datetime
) engine =ReplicatedMergeTree('/clickhouse/tables/01/rep_t_order_mt2020','rep_hadoop102')
partition by toYYYYMMDD(create_time)
primary key (id)
order by (id,sku_id);

在hadoop103上建表
create table rep_t_order_mt2020 (
    id UInt32,
    sku_id String,
    total_amount Decimal(16,2),
    create_time  Datetime
) engine =ReplicatedMergeTree('/clickhouse/tables/01/rep_t_order_mt2020','rep_hadoop103')
partition by toYYYYMMDD(create_time)
primary key (id)
order by (id,sku_id);

说明
ReplicatedMergeTree('/clickhouse/tables/01/rep_t_order_mt2020','rep_hadoop103')

	参数1: 该表在zookeeper中的路径.
	/clickhouse/table/{shard}/{table_name}  通常写法,
	shard表示表的分片编号, 一般用01,02,03…表示
	table_name 一般和表明保持一致就行
	参数2: 在zookeeper中的复本名.  相同的表, 复本名不能相同

    分片集群：
    复本虽然能够提高数据的可用性，降低丢失风险，但是对数据的横向扩容没有解决。每台机子实际上必须容纳全量数据。
	要解决数据水平切分的问题，需要引入分片的概念。
	通过分片把一份完整的数据进行切分，不同的分片分布到不同的节点上。在通过Distributed表引擎把数据拼接起来一同使用。
	Distributed表引擎 本身不存储数据，有点类似于MyCat之于MySql，成为一种中间件，通过分布式逻辑表来写入、分发、路由来操作多台节点不同分片的分布式数据。

    要在配置文件配置

 */

public class $01_demo_1 {


}


