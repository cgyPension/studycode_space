package com.cgy.SparkStreaming.req_1.application

import com.cgy.SparkStreaming.req_1.controller.MockDataController
import com.cgy.summer.framework.core._
object MockDataApplication extends App with TApplication {

  start("sparkStreaming"){
    val controller: MockDataController = new MockDataController
    controller.execute()
  }
}
