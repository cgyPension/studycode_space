package com.cgy.SparkStreaming.req_1.application

import com.cgy.SparkStreaming.req_1.controller.DateAreaCityAdCountAnalysisController
import com.cgy.summer.framework.core._
object DateAreaCityAdCountAnalysisApplication extends App with TApplication {


  start("sparkStreaming"){
     val dateAreaCityAdCountAnalysisController: DateAreaCityAdCountAnalysisController = new DateAreaCityAdCountAnalysisController
    dateAreaCityAdCountAnalysisController.execute()
  }


}
