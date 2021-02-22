package com.cgy

import java.util

import redis.clients.jedis.Jedis

import scala.collection.JavaConverters._

object RedisDemo {
  def main(args: Array[String]): Unit = {
    // 创建一个redis客户端
    val client: Jedis = new Jedis("hadoop102", 6379)
    // 使用客户端进行各种操作
    // 1. 写入字符串
    client.set("a1","v1")
    client.set("name","麻花")

    // 2. 写入list
    client.rpush("list1","l","o","v","e")
    val list1: util.List[String] = client.lrange("list1", 0, -1)
    for (e <- list1.asScala) {
      println(e)
    }

    // 3. 写入set集合
    client.sadd("set1","1","2","3","4")
    val set1: util.Set[String] = client.smembers("set1")
    set1.asScala.foreach(println)

    println(client.sadd("set1", "10"))
    println(client.sadd("set1", "10"))

    // 4. hash
    client.hset("hash1","f1","v1")
    val map = Map("a"->"97","b"->"98",("c","99"))

    client.hmset("hash1",map.asJava)

    // 5. zsh

    // println(client.get("name"))
    // 关闭
    client.close()
  }

}
