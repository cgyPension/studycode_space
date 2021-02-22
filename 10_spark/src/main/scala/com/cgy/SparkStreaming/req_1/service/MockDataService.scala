package com.cgy.SparkStreaming.req_1.service

import com.cgy.SparkStreaming.req_1.dao.MockDataDao
import com.cgy.summer.framework.core._
class MockDataService extends TService{

  private val mockDataDao: MockDataDao = new MockDataDao

  /**
   * 数据分析
   * @return
   */
  override def analysis(): Any = {
    // TODO 生成模拟数据
    //import mockDataDao._
    val datas = mockDataDao.genMockData()

    //val a = Seq("a")

    // TODO 向Kafka中发送数据
    mockDataDao.writeToKakfa(datas)
  }

}
