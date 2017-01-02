package com.miaolegemitong.basics.scala.basic

/**
  * @author miaolegemitong
  */
object IfElse {
  def main(args: Array[String]) {
    val i = 10
    val a = if (i <= 10) "aaa" else -1
    println(a.getClass)
    val b = if (i > 10) "aaa"
    println(b.getClass)
    println(b)
  }
}
