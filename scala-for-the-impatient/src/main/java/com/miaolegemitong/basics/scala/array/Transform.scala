package com.miaolegemitong.basics.scala.array

/**
  * @author miaolegemitong
  */
object Transform {
  def main(args: Array[String]): Unit = {
    val a = Array(2, 3, 5, 7, 11)
    //使用for推导式
    val result = for (elem <- a) yield 2 * elem
    println(result.getClass) //数组转换之后也是数组
    result.foreach(a => print(a + " "))
    println()

    val ab = a.toBuffer
    //使用for推导式
    val bufferResult = for (elem <- ab) yield 2 * elem
    println(bufferResult.getClass) //数组缓冲转换之后也是数组缓冲
    bufferResult.foreach(a => print(a + " "))
    println()

    //另一种做法
    a.filter(_ % 2 == 0).map(2 * _).foreach(a => print(a + " "))
  }
}
