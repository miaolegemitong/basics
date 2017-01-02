package com.miaolegemitong.basics.scala.array

import scala.collection.mutable.ArrayBuffer

/**
  * @author miaolegemitong
  */
object Traversal {
  def main(args: Array[String]): Unit = {
    val ab = ArrayBuffer(1, 2, 3, 4)
    //每两个一跳
    for (i <- 0 until (ab.length, 2)) print(ab(i) + " ")
    println()
    //倒着读
    for (i <- ab.indices.reverse) print(ab(i) + " ")
    println()
    //不需要下标直接取元素
    for (elem <- ab) print(elem + " ")
  }
}
