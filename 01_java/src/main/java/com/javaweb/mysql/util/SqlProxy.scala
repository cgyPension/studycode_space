package com.javaweb.mysql.util

import java.sql.{Connection, PreparedStatement, ResultSet}

import scala.collection.mutable.ArrayBuffer

/**
 * jdbc工具类
 */
trait QueryCallback {
  def process(rs: ResultSet)
}

class SqlProxy {
  private var rs: ResultSet = _
  private var psmt: PreparedStatement = _

  /**
   * 执行修改语句
   *
   * @param conn
   * @param sql
   * @param params
   * @return
   */
  def executeUpdate(conn: Connection, sql: String, params: Array[Any]): Int = {
    var rtn = 0
    try {
      psmt = conn.prepareStatement(sql)
      if (params != null && params.length > 0) {
        for (i <- 0 until params.length) {
          psmt.setObject(i + 1, params(i))
        }
      }
      rtn = psmt.executeUpdate()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    rtn
  }

  def executeBatch(conn: Connection, sql: String, params: ArrayBuffer[ArrayBuffer[Any]]): Int = {
    var rtn = 0
    try {
      conn.setAutoCommit(false); // 设置手动提交
      psmt = conn.prepareStatement(sql)
      if (params != null && params.length > 0) {
        for (i <- 0 until params.length) {
          for (j <- 0 until params(i).length) {
            psmt.setObject(j + 1, params(i)(j))
          }
          rtn += 1
          psmt.addBatch()
          if ((i != 0 && i % 1000 == 0) || i == params.length - 1) {
            psmt.executeBatch()
            conn.commit()
            psmt.clearBatch()
          }
        }
      }
      /*psmt.executeBatch()
      conn.commit(); // 提交
      psmt.clearBatch()*/
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    rtn
  }


  /**
   * 执行查询语句
   * 执行查询语句
   *
   * @param conn
   * @param sql
   * @param params
   * @return
   */
  def executeQuery(conn: Connection, sql: String, params: Array[Any], queryCallback: QueryCallback) = {
    rs = null
    try {
      psmt = conn.prepareStatement(sql)
      if (params != null && params.length > 0) {
        for (i <- 0 until params.length) {
          psmt.setObject(i + 1, params(i))
        }
      }
      rs = psmt.executeQuery()
      queryCallback.process(rs)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  def shutdown(conn: Connection): Unit = SqlServerConnection.closeResource(rs, psmt, conn)

}
