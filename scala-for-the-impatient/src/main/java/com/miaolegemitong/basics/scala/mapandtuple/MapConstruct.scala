package com.miaolegemitong.basics.scala.mapandtuple

/**
  * @author miaolegemitong
  */
object MapConstruct {
  def main(args: Array[String]): Unit = {
    //不可变映射
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    //可变映射
    val scores1 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    //空映射
    val scores2 = new scala.collection.mutable.HashMap[String, Int]

    //用对偶创建映射
    val scores3 = Map(("Alice", 2), ("Bob", 3), ("Cindy", 8))
  }
}
