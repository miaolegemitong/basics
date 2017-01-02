package com.miaolegemitong.basics.scala.array

/**
  * @author miaolegemitong
  */
object FixedLengthDemo {
  def main(args: Array[String]) {
    /**
      * 定长数组
      **/
    //所有元素均初始化为0
    val nums = new Array[Int](10)

    //所有元素均初始化为null
    val strs = new Array[String](10)

    //提供初始值进行实例化不需要new
    val ss = Array("Hello", "World")
    ss(0) = "AAA"
    for (s <- ss) print(s + " ")
    println()
  }
}
