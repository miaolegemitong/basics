package com.miaolegemitong.basics.scala.mapandtuple

/**
  * @author miaolegemitong
  */
object SortedTreeMap {
  def main(args: Array[String]): Unit = {
    val scores = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)

    //按插入顺序访问
    val months = scala.collection.mutable.LinkedHashMap("January" -> 1, "Febrary" -> 2, "March" -> 3, "April" -> 4, "May" -> 5)
  }
}
