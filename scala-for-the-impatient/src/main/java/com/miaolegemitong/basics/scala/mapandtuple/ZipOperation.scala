package com.miaolegemitong.basics.scala.mapandtuple

/**
  * @author miaolegemitong
  */
object ZipOperation {
  def main(args: Array[String]): Unit = {
    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts)
    for ((s, n) <- pairs) print(s * n)
  }
}
