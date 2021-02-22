package com.cgy.SparkCore.req.application

import com.cgy.SparkCore.req.controller.WordCountController
import com.cgy.summer.framework.core.TApplication
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object WordCountApplication extends App with TApplication{

    start( "spark" ) {

        val controller = new WordCountController
        controller.execute()

    }

}
