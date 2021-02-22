package com.cgy.charpter09

import java.time.LocalDate

object ImpDemo {
  def main(args: Array[String]): Unit = {

    val ago ="ago"
    val later = "later"
    val s1 = 10 days ago // 10.days(ago)
    val s2 = 10 days later // 10.days(ago)
    println(s1)
    println(s2)
  }

  implicit class RichInt(day:Int){
    def days(when:String):String={
      when match {
        case "ago" =>
          LocalDate.now().minusDays(day).toString
        case "later" =>
          LocalDate.now().plusDays(day).toString
        case _ => throw new UnsupportedOperationException
      }
    }
  }
}
