package com.cgy

object NameValue {
  def main(args: Array[String]): Unit = {

    def a ={
      println("a........")
      7
    }


    // TODO 值调用:
    println("=============值调用==============")
    def foo1(i:Int): Unit ={
      i
      i
      i
    }

    foo1(a)

    // TODO 名调用:
    println("=============名调用==============")
    def foo2(i: => Unit): Unit ={
      i
      i
      i
    }

    foo2(a)


  }
}
