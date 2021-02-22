package com.cgy.SparkStreaming.req_1.controller

import com.cgy.SparkStreaming.req_1.service.LasHourAdCountAnalysisService
import com.cgy.summer.framework.core.TController

class LasHourAdCountAnalysisController extends TController{

    private val lasHourAdCountAnalysisService = new LasHourAdCountAnalysisService

    override def execute(): Unit = {
        val result = lasHourAdCountAnalysisService.analysis()
    }
}
