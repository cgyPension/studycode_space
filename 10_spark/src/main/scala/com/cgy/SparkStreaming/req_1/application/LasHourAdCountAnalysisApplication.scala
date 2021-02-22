package com.cgy.SparkStreaming.req_1.application

import com.cgy.SparkStreaming.req_1.controller.LasHourAdCountAnalysisController
import com.cgy.summer.framework.core.TApplication

object LasHourAdCountAnalysisApplication extends App with TApplication{

    start( "sparkStreaming" ) {
        val controller = new LasHourAdCountAnalysisController
        controller.execute()
    }
}
