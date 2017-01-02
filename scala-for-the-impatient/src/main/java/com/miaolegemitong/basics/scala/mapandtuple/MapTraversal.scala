package com.miaolegemitong.basics.scala.mapandtuple

/**
  * @author miaolegemitong
  */
object MapTraversal {
  def main(args: Array[String]): Unit = {
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    for ((name, score) <- scores) printf("%s->%d\n", name, score)
    scores.keySet //得到key的集合
    scores.values //得到value的集合
    val reverse = for ((k, v) <- scores) yield (v, k) //反转映射
  }
}
