package com.cgy.SparkStreaming.req_1.application

import com.cgy.SparkStreaming.req_1.controller.BlackListController
import com.cgy.summer.framework.core._
object BlackListApplication extends App with TApplication {

  start("sparkStreaming"){
    val controller: BlackListController = new BlackListController
    controller.execute()
  }


}
