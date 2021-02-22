-- 枚举类 对一些状态、类型的字段算是一种空间优化，也算是一种数据约束。
-- 但是实际使用中往往因为一些数据内容的变化增加一定的维护成本，甚至是数据丢失问题，谨慎使用

-- insert values
INSERT INTO [db.]table [(c1, c2, c3)] VALUES (v11, v12, v13), (v21, v22, v23), ...

-- insert select
    INSERT INTO [db.]table [(c1, c2, c3)] SELECT ...

-- ClickHouse提供了Delete 和Update的能力 虽然可以实现修改和删除，但是和一般的OLTP数据库不一样，Mutation语句是一种很“重”的操作，而且不支持事务。
-- 	“重”的原因主要是每次修改或者删除都会导致放弃目标数据的原有分区，重建新分区。所以尽量做批量的变更，不要进行频繁小数据的操作。

-- 删除操作
                                              alter table t_order_smt delete where sku_id ='sku_001';
-- 修改操作
alter table t_order_smt update total_amount=toDecimal32(2000.00,2) where id =102;
-- 由于操作比较“重”，所以 Mutation语句分两步执行，同步执行的部分其实只是进行新增数据新增分区和并把旧分区打上逻辑上的失效标记。
-- 直到触发分区合并的时候，才会删除旧数据释放磁盘空间。

-- 查询操作 clickhouse基本上与标准SQL差别不大
-- WITH clause
-- FROM clause
-- SAMPLE clause
-- JOIN clause
-- PREWHERE clause
-- WHERE clause
-- GROUP BY clause
-- LIMIT BY clause
-- HAVING clause
-- SELECT clause
-- DISTINCT clause
-- LIMIT clause
-- UNION ALL clause
-- INTO OUTFILE clause
-- FORMAT clause

-- 不支持窗口函数
-- 暂时不支持自定义函数
-- group by 子句特殊说明:
-- GROUP BY 操作增加了 with rollup\with cube\with total 用来计算小计和总计
-- with rollup 分组的列从右至左去掉维度进行小计
select id , sku_id,sum(total_amount) from  t_order_mt group by id,sku_id with rollup;

-- with cube: 各种维度组合进行聚合
select id , sku_id,sum(total_amount) from  t_order_mt group by id,sku_id with cube;

-- with taotals: 仅仅多了一个总计
select id , sku_id,sum(total_amount) from  t_order_mt group by id,sku_id with totals;

-- alter操作 同mysql的修改字段基本一致
-- 新增字段
alter table tableName  add column  newcolname  String after col1;

-- 修改字段类型
alter table tableName  modify column  newcolname  String;

-- 删除字段
alter table tableName  drop column  newcolname;

-- 导出数据
clickhouse-client --query "SELECT * from table" --format CSVWithNames> ~/rs1.csv