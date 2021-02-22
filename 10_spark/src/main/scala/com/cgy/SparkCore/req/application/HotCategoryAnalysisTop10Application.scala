package com.cgy.SparkCore.req.application

import com.cgy.SparkCore.req.controller.HotCategoryAnalysisTop10Controller
import com.cgy.summer.framework.core.TApplication
object HotCategoryAnalysisTop10Application extends App with TApplication{

    // TODO 热门品类前10应用程序
    start("spark") {
        val controller = new HotCategoryAnalysisTop10Controller
        controller.execute()
    }
}
