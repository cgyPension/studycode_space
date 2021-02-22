package com.cgy.charpter03

object ReturnDemo2 {
  def main(args: Array[String]): Unit = {
    var i = 1
    myWhile(i <= 100){
      println(i)
      i+=1
    }
  }

  def myWhile(condition: => Boolean)(op: => Unit):Unit= {
    if (condition) {
        op
        myWhile(condition)(op)
    }
  }
}
