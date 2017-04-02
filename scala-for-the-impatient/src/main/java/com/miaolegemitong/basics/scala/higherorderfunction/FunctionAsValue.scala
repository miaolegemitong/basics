package com.miaolegemitong.basics.scala.higherorderfunction

import scala.math._

/**
  * @author miaolegemitong
  */
object FunctionAsValue {
  def main(args: Array[String]): Unit = {
    val num = 3.14
    /**
      * 包含函数的变量
      * _表示确实指ceil函数，而不是碰巧忘了传参数
      * fun的类型为(Double)=>Double
      * */
    val fun = ceil _
    println(fun(num)) //调用
    Array(3.14, 1.42, 2.0).map(fun).foreach(a => print(a + " ")) //传递
  }
}
