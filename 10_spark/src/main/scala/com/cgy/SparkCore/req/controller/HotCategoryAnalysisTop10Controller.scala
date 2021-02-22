package com.cgy.SparkCore.req.controller

import com.cgy.SparkCore.req.service.HotCategoryAnalysisTop10Service
import com.cgy.summer.framework.core.TController

class HotCategoryAnalysisTop10Controller extends TController {

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service

    override def execute(): Unit = {
        val result = hotCategoryAnalysisTop10Service.analysis()

        result.foreach(println)
    }
}
