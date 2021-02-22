package com.cgy

import java.text.SimpleDateFormat

//求得每个用户一小时内最大的登录次数user_id,login_time

object Test02 {
  def dateStrToLong(dateStr:String):Long = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    format.parse(dateStr).getTime
  }

  def main(args: Array[String]): Unit = {
    val list = List(
      "a,2020-07-11 10:51:12",
      "a,2020-07-11 11:05:00",
      "a,2020-07-11 11:15:20",
      "a,2020-07-11 11:25:05",
      "a,2020-07-11 11:45:00",
      "a,2020-07-11 11:55:36",
      "a,2020-07-11 11:59:56",
      "a,2020-07-11 12:35:12",
      "a,2020-07-11 12:58:59",
      "b,2020-07-11 14:51:12",
      "b,2020-07-11 14:05:00",
      "b,2020-07-11 15:15:20",
      "b,2020-07-11 15:25:05",
      "b,2020-07-11 16:45:00",
      "b,2020-07-11 16:55:36",
      "b,2020-07-11 16:59:56",
      "b,2020-07-11 17:35:12",
      "b,2020-07-11 17:58:59"
    )

    //1、切割字符串，时间转为long类型
    val splitData = list.map(line=>{
      val arr = line.split(",")
      val id = arr.head
      val time = dateStrToLong(arr.last)
      (id,time)
    })
    //[
    //    (a,2020-07-11 10:51:12),
    //    (a,2020-07-11 11:05:00),
    //    (a,2020-07-11 11:15:20),
    //    (a,2020-07-11 11:25:05),
    //    (a,2020-07-11 11:45:00),
    //    (a,2020-07-11 11:55:36),
    //    (a,2020-07-11 11:59:56),
    //    (a,2020-07-11 12:35:12),
    //    (a,2020-07-11 12:58:59),
    //    (b,2020-07-11 14:51:12),
    //    (b,2020-07-11 14:05:00),
    //    (b,2020-07-11 15:15:20),
    //    (b,2020-07-11 15:25:05),
    //    (b,2020-07-11 16:45:00),
    //    (b,2020-07-11 16:55:36),
    //    (b,2020-07-11 16:59:56),
    //    (b,2020-07-11 17:35:12),
    //    (b,2020-07-11 17:58:59)
    // ]


    //2、分組
    val grouped = splitData.groupBy(_._1)
    //[
    //  a -> List(
    //         (a,2020-07-11 10:51:12),
    //        (a,2020-07-11 11:05:00),
    //        (a,2020-07-11 11:15:20),
    //        (a,2020-07-11 11:25:05),
    //        (a,2020-07-11 11:45:00),
    //        (a,2020-07-11 11:55:36),
    //        (a,2020-07-11 11:59:56),
    //        (a,2020-07-11 12:35:12),
    //        (a,2020-07-11 12:58:59),
    //    ),
    //  b->List(
    //    (b,2020-07-11 14:51:12),
    //    (b,2020-07-11 14:05:00),
    //    (b,2020-07-11 15:15:20),
    //    (b,2020-07-11 15:25:05),
    //    (b,2020-07-11 16:45:00),
    //    (b,2020-07-11 16:55:36),
    //    (b,2020-07-11 16:59:56),
    //    (b,2020-07-11 17:35:12),
    //    (b,2020-07-11 17:58:59)
    //    )
    // ]
    grouped.map(x=>{
      val id = x._1
      val alldata = x._2
      //List(
      //      (a,2020-07-11 10:51:12),
      //     (a,2020-07-11 11:05:00),
      //     (a,2020-07-11 11:15:20),
      //     (a,2020-07-11 11:25:05),
      //     (a,2020-07-11 11:45:00),
      //     (a,2020-07-11 11:55:36),
      //     (a,2020-07-11 11:59:56),
      //     (a,2020-07-11 12:35:12),
      //     (a,2020-07-11 12:58:59),
      // ),

      val userstime = alldata.map(y=>{
        //y = (a,2020-07-11 10:51:12)
        val currentTime = y._2
        //3、根据每条数据的时间筛选哪个数据与它处于一个小时的时间段
        val timesdata = alldata.filter(z=>{
          z._2>=currentTime && z._2-currentTime<=3600000
        })

        //4、统计时间段的登陆次数
        (currentTime,timesdata.size)
      })


      //5、取得最大值
      val num = userstime.map(_._2).max
      //[
      //  2020-07-11 10:51:12->5,
      //  2020-07-11 11:05:00 -> 6,
      //  2020-07-11 11:15:20 ->5,
      //  ...
      //  ...
      // ]
      (id,num)
    }).foreach(println(_))



  }
}
