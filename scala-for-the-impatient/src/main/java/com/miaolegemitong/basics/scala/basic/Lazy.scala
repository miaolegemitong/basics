package com.miaolegemitong.basics.scala.basic

/**
  * @author miaolegemitong
  */
object Lazy {
  def main(args: Array[String]) {
    lazy val lazyWords = scala.io.Source.fromFile("/home/milton/test1").mkString
    val notLazyWords = scala.io.Source.fromFile("/home/milton/test1").mkString
    println(lazyWords)
  }
}
