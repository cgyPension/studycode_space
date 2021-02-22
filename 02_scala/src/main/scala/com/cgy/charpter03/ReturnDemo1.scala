package com.cgy.charpter03

object ReturnDemo1 {

  def main(args: Array[String]): Unit = {

    val list1 = List(30, 50, 70, 60, 10, 20)


    /*list1.foreach(x => {
        try{
            if(x > 60) return
            println(x)
        }catch {
            case _ =>
        }
    })*/

    list1.foreach(foo)

    println("xxxxxx")

  }

  def foo(x: Int): Unit = {
    if (x > 60) return
    println(x)
  }
}
