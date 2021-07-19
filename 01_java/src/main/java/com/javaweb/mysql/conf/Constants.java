package com.javaweb.mysql.conf;

//import org.nustaq.serialization.util.test;

/**
 * JDBC常量接口
 *
 */

public interface Constants {
	/**
	 * 项目配置常量
	 */
	// Hive
	public String Hive_URL="jdbc.hive.url";
	public String Hive_USER="jdbc.hive.user";
	public String Hive_PASSWORD="jdbc.hive.password";

	// Clickhouse生产环境内网
	public String CLICKHOUSE_PROD_URL="clickhouse_prod_url";
	public String CLICKHOUSE_PROD_USER="clickhouse_prod_user";
	public String CLICKHOUSE_PROD_PWD="clickhouse_prod_pwd";

	// Clickhouse生产环境外网
	public String CLICKHOUSE_PROD_OUTER_URL="clickhouse_prod_outer_url";
	public String CLICKHOUSE_PROD_OUTER_USER="clickhouse_prod_outer_user";
	public String CLICKHOUSE_PROD_OUTER_PWD="clickhouse_prod_outer_pwd";

	// Clickhouse测试环境内网
	public String CLICKHOUSE_DEV_URL="clickhouse_dev_url";
	public String CLICKHOUSE_DEV_USER="clickhouse_dev_user";
	public String CLICKHOUSE_DEV_PWD="clickhouse_dev_pwd";

	// Clickhouse测试环境外网
	public String CLICKHOUSE_DEV_OUTER_URL="clickhouse_dev_outer_url";
	public String CLICKHOUSE_DEV_OUTER_USER="clickhouse_dev_outer_user";
	public String CLICKHOUSE_DEV_OUTER_PWD="clickhouse_dev_outer_pwd";

	// MySql
	public String QC_MYSQL_URL="QC.mysql.url";
	public String QC_MYSQL_USER="QC.mysql.user";
	public String QC_MYSQL_PASSWD="QC.mysql.passwd";

	public String YFB_MYSQL_URL="YFB.mysql.url";
	public String YFB_MYSQL_USER="YFB.mysql.user";
	public String YFB_MYSQL_PASSWD="YFB.mysql.passwd";

	public String JYJ_MYSQL_URL="JYJ.mysql.url";
	public String JYJ_MYSQL_USER="JYJ.mysql.user";
	public String JYJ_MYSQL_PASSWD="JYJ.mysql.passwd";

	public String JYJ_MYSQL_EXTERNAL_URL="JYJ.mysql.external.url";
	public String JYJ_MYSQL_EXTERNAL_USER="JYJ.mysql.external.user";
	public String JYJ_MYSQL_EXTERNAL_PASSWD="JYJ.mysql.external.passwd";

	public String LXJ_MYSQL_URL="lxj.mysql.url";
	public String LXJ_MYSQL_USER="lxj.mysql.user";
	public String LXJ_MYSQL_PASSWD="lxj.mysql.passwd";

	public String PROD_MYSQL_URL="prod.mysql.url";
	public String PROD_MYSQL_USER="prod.mysql.user";
	public String PROD_MYSQL_PASSWD="prod.mysql.passwd";

	// Kafka 配置
	public String KAFKA_MAX_PARTITION_FETCH_SIZE="max.partition.fetch.bytes"; //Message消息体分配的内存大小
	public String KAFKA_RECEIVE_BUFFER_SIZE="receive.buffer.bytes"; //Message消息体分配的内存大小
	public String KAFKA_MAX_POLL_SIEZ="max.poll.records"; // 单词最大拉取

	public String KAFKA_KEY_DESERIALIZER="kafka.key.deserializer"; // Kafka: key反序列化
	public String KAFKA_VALUE_DESERIALIZER="kafka.value.deserializer"; //Kafaka: value反序列化
	public String KAFKA_KEY_SERIALIZER="kafka.key.serializer"; // Kafka: key反序列化
	public String KAFKA_VALUE_SERIALIZER="kafka.value.serializer"; //Kafaka: value反序列化

	public String KAFKA_BROKERS="kafka.brokers";
	public String KAFKA_BROKERS_PROD="kafka.brokers.prod";
	public String KAFKA_BROKERS_DEV="kafka.brokers.dev";

	// Spark 配置
	public String SPARK_MASTER="spark.master"; // SPARK: 设置Master，运行模式
	public String SPARK_MASTER_PROD="spark.master_prod"; // SPARK: 设置Master，运行模式

	// Zookeeper 配置
	public String ZK_SERVER_URLS="zk.server.urls"; // Zookeeper: 生产zk地址
	public String ZK_SERVER_URLS_PROD="zk.server.urls.prod"; // Zookeeper: 生产zk地址
	public String ZK_SERVER_MAX_ACTIVATE="zk.server.max.active";
	public String ZK_SERVER_WAIT_MAX="zk.server.wait.max";
	public String ZK_SERVER_SESSION_TIMEOUT="zk.server.session.timeout";

	// Redis 连接池
	public String REDIS_SERVER_HOST="redis.server.host";
	public String REDIS_SERVER_PORT="redis.server.port";
	public String REDIS_SERVER_PASSWORD="redis.server.password";
	public String REDIS_SERVER_HOST_PROD="redis.server.host.prod";
	public String REDIS_SERVER_PORT_PROD="redis.server.port.prod";
	public String REDIS_SERVER_PASSWORD_PROD="redis.server.password.prod";

    // Redis 哨兵模式
	public String REDIS_SENTINEL_MASTER_NAME="redis.sentinel.master.name";
	public String REDIS_SENTINEL_HOSTS="reids.sentinel.hosts";
	public String REDIS_SENTINEL_HOSTS_PROD="reids.sentinel.hosts.prod";

	// Phoenix
	public String PHOENIX_SERVER="phoenix.server";
	public String PHOENIX_PROD="phoenix.brokers.prod";

	public static final String HBASE_SCHEMA="hbase.schema";


	// TODO ======================================== 公司项目 ========================================




}