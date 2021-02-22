package com.cgy.SparkStreaming.req_2.utils

import java.sql.{Connection, PreparedStatement, ResultSet}
import com.alibaba.druid.pool.DruidDataSourceFactory

import javax.sql.DataSource
import scala.collection.mutable.ListBuffer

object JDBCUtil {

    // 创建连接池对象
    var dataSource:DataSource = init()

    // 连接池的初始化
    def init():DataSource = {

        val paramMap = new java.util.HashMap[String, String]()
        paramMap.put("driverClassName", PropertiesUtil.getValue("jdbc.driver.name"))
        paramMap.put("url", PropertiesUtil.getValue("jdbc.url"))
        paramMap.put("username", PropertiesUtil.getValue("jdbc.user"))
        paramMap.put("password", PropertiesUtil.getValue("jdbc.password"))
        paramMap.put("maxActive", PropertiesUtil.getValue("jdbc.datasource.size"))

        // 使用Druid连接池对象
        DruidDataSourceFactory.createDataSource(paramMap)
    }

    // 从连接池中获取连接对象
    def getConnection(): Connection = {
        dataSource.getConnection
    }

    def main(args: Array[String]): Unit = {

        println(getConnection())

        val connection: Connection = JDBCUtil.getConnection()

        /*val sql1 =
            """
              |create table t_job_tt
              |(
              |    job_id      int auto_increment
              |        primary key,
              |    job_name    varchar(20)  null,
              |    description varchar(200) null
              |);
              |""".stripMargin

        val ps: PreparedStatement = connection.prepareStatement(sql1)

        //ps.setString(1,"t_job_tthh") //在这样建表的时候不能这样用通配符
        ps.execute()
        ps.close()*/

        val ps2: PreparedStatement = connection.prepareStatement("select *from test.xhello;")

        val rs: ResultSet = ps2.executeQuery()

        while(rs.next()) {
            //println(rs.getInt(1))
            println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3))

        }

        rs.close()
        ps2.close()
        connection.close()
    }
}
