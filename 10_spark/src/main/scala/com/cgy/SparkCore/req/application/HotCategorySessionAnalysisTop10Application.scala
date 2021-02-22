package com.cgy.SparkCore.req.application

import com.cgy.SparkCore.req.controller.HotCategorySessionAnalysisTop10Controller
import com.cgy.summer.framework.core.TApplication

object HotCategorySessionAnalysisTop10Application extends App with TApplication{

    // TODO 热门品类前10应用程序
    start("spark") {
        val controller = new HotCategorySessionAnalysisTop10Controller
        controller.execute()
    }
}
