package com.miaolegemitong.basics.scala.array

import scala.collection.mutable.ArrayBuffer

/**
  * @author miaolegemitong
  */
object UnfixedLengthDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 变长数组：数组缓冲
      **/
    val ab = new ArrayBuffer[Int]()
    //在尾部添加元素
    ab += 1
    //在尾部添加多个元素
    ab += (2, 3, 4, 5)
    //在尾部添加任何集合
    ab ++= Array(6, 7, 8)
    //移除最后的元素
    ab.trimEnd(5)
    for (s <- ab) print(s + " ")
    println()
    //在任意位置插入
    ab.insert(2, 4)
    ab.insert(2, 5, 6, 7)
    ab.remove(2)
    ab.remove(2, 3)
  }
}
