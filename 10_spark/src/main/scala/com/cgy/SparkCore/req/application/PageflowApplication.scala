package com.cgy.SparkCore.req.application

import com.cgy.SparkCore.req.controller.PageflowController
import com.cgy.summer.framework.core.TApplication

object PageflowApplication extends App with TApplication{

    start( "spark" ) {
        val controller = new PageflowController
        controller.execute()
    }
}
