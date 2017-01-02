package com.miaolegemitong.basics.scala.basic

/**
  * @author miaolegemitong
  */
object Sort {
  def main(args: Array[String]) {
    val a = List((1, "a"), (4, "b"), (2, "dd"), (3, "d"))
    val b = a.sortWith((a, b) => {
      a._1 > b._1
    })
    println(b.take(2))
  }
}
