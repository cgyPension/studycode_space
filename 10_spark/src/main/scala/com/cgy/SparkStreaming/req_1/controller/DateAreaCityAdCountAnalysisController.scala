package com.cgy.SparkStreaming.req_1.controller

import com.cgy.SparkStreaming.req_1.service.DateAreaCityAdCountAnalysisService
import com.cgy.summer.framework.core._
class DateAreaCityAdCountAnalysisController extends TController {

   val service: DateAreaCityAdCountAnalysisService = new DateAreaCityAdCountAnalysisService
  override def execute(): Unit = {
    val result: Any = service.analysis()
  }
}
