package com.cgy.SparkCore.req.controller

import com.cgy.SparkCore.req.service.WordCountService
import com.cgy.summer.framework.core.TController
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * WordCount控制器
  */
class WordCountController extends TController{

    private val wordCountService = new WordCountService

    override def execute(): Unit = {
        val wordCountArray: Array[(String, Int)] = wordCountService.analysis()
        println(wordCountArray.mkString(","))
    }
}
