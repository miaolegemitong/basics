package com.miaolegemitong.basics.scala.mapandtuple

/**
  * @author miaolegemitong
  */
object MapSelectUpdate {
  def main(args: Array[String]): Unit = {
    val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    println(scores("Bob")) //类似于Java的get方法，如果不包含此key，抛出异常
    println(if (scores.contains("Bob")) scores("Bob") else 0) //contains相当于Java的containsKey
    println(scores.getOrElse("Bob", 0)) //Option

    scores("Bob") = 10 //Update
    scores("Fred") = 7 //Insert
    scores += ("Bob" -> 10, "Fred" -> 7) //Update and Insert
    scores -= "Alice" //Delete
  }
}
