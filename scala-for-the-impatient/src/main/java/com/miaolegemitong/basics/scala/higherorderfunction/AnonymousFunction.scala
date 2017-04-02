package com.miaolegemitong.basics.scala.higherorderfunction

/**
  * @author miaolegemitong
  */
object AnonymousFunction {
  def main(args: Array[String]): Unit = {
    val triple = (x: Double) => 3 * x
    Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x).foreach(x => print(x + " "))
  }
}
