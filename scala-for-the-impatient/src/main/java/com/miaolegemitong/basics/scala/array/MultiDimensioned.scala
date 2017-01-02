package com.miaolegemitong.basics.scala.array

/**
  * @author miaolegemitong
  */
object MultiDimensioned {
  def main(args: Array[String]): Unit = {
    //每行列数相同
    val matrix = Array.ofDim[Double](3, 4) //三行，四列
    matrix(1)(2) = 10
    for (row <- matrix) {
      println(row.mkString(","))
    }

    //不规则数组，每一行的长度各不相同
    val triangle = new Array[Array[Int]](10)
    for (i <- triangle.indices) {
      triangle(i) = new Array[Int](i + 1)
    }
  }
}
