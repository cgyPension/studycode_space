package com.cgy.SparkCore.req.dao

import com.cgy.SparkCore.req.bean.UserVisitAction
import com.cgy.summer.framework.core.TDao
import org.apache.spark.rdd.RDD

class HotCategorySessionAnalysisTop10Dao extends TDao {

    def getUserVisitAction( path:String ) = {
        val rdd: RDD[String] = readFile(path)
        rdd.map(
            line => {
                val datas = line.split("_")
                UserVisitAction(
                    datas(0),
                    datas(1).toLong,
                    datas(2),
                    datas(3).toLong,
                    datas(4),
                    datas(5),
                    datas(6).toLong,
                    datas(7).toLong,
                    datas(8),
                    datas(9),
                    datas(10),
                    datas(11),
                    datas(12).toLong
                )
            }
        )
    }
}
