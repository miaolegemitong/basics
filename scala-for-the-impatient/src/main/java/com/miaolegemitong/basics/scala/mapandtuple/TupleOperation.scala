package com.miaolegemitong.basics.scala.mapandtuple

/**
  * @author miaolegemitong
  */
object TupleOperation {
  def main(args: Array[String]): Unit = {
    val tuple = (1, 3.14, "Fred")
    println(tuple.getClass)
    println(tuple._2)

    val (first, second, _) = tuple
    println(first)
    println(second)

    println("New York".partition(_.isUpper))
  }
}