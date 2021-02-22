package com.cgy.SparkStreaming.req_1.controller

import com.cgy.SparkStreaming.req_1.service.BlackListService
import com.cgy.summer.framework.core._
class BlackListController extends TController {

  val blackListService: BlackListService = new BlackListService

  override def execute(): Unit = {
    val result = blackListService.analysis()
  }


}
