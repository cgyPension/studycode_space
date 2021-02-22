package com.cgy.SparkCore.req.controller

import com.cgy.SparkCore.req.service.PageflowService
import com.cgy.summer.framework.core.TController

class PageflowController extends TController{

    private val pageflowService = new PageflowService

    override def execute(): Unit = {
        val result = pageflowService.analysis()
    }
}
