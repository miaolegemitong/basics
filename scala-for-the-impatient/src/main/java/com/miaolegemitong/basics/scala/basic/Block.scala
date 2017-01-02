package com.miaolegemitong.basics.scala.basic

import math._

/**
  * @author miaolegemitong
  */
object Block {
  def main(args: Array[String]) {
    val x, y = 10
    val x0, y0 = 5
    val distance = {
      val dx = x - x0
      val dy = y - y0
      sqrt(dx * dx + dy * dy)
    }
    println(distance)

    var m = 10
    val aaa = { m += 1 }
    println(aaa)
  }
}
