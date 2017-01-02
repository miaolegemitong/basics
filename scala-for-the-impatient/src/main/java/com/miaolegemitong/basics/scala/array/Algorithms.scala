package com.miaolegemitong.basics.scala.array

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

/**
  * @author miaolegemitong
  */
object Algorithms {
  def main(args: Array[String]): Unit = {
    println(Array(1, 7, 2, 9).sum)

    println(ArrayBuffer("Mary", "head", "a", "little", "lamb").max)

    //排序生成新的对象
    val b = ArrayBuffer(1, 7, 2, 9)
    println(b.sorted.mkString(",")) //b.sorted返回一个新的ArrayBuffer

    val array = Array(("aaa,", 0), ("bbb", 3), ("ccc",1), ("ddd",4), ("eee",-1), ("fff",5))
    val temp = array.sortWith(_._2 - _._2 > 0).take(3) //array.sortWith返回一个新的Array
    println(temp.mkString(","))

    //直接对数组排序，不能排序ArrayBuffer
    val a = Array(1, 7, 2, 9)
    Sorting.quickSort(a)
    println(a.mkString(","))
  }
}
