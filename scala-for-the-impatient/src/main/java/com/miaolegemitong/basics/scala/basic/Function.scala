package com.miaolegemitong.basics.scala.basic

import math._

/**
  * @author miaolegemitong
  */
object Function {
  def main(args: Array[String]) {
    println(sqrt(2))
    println(pow(2, 4))
    println(min(3, Pi))

    //自动推断返回类型
    def fac(n: Int) = {
      var r = 1
      for (i <- 1 to n) r = r * i
      r
    }
    println(fac(10))

    //递归函数也可以不指定返回类型
    def fac1(n: Int) = {
      if (n <= 0) 1
      else n * fac(n - 1)
    }
    println(fac1(10))

    //默认参数和带名参数
    def decorate(str: String, left: String = "[", right: String = "]") = { left + str + right }
    println(decorate("aaa"))
    println(decorate("aaa", "<<<"))
    println(decorate("aaa", right = ">>>"))
    println(decorate(left = "<<<", str = "aaa", right = ">>>"))

    //变长参数
    def sum(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
    }
    println(sum(1, 2, 3, 4, 5))
    println(sum(1 to 5: _*))
    //递归变长函数
    def recursiveSum(args: Int*): Int = {
      if (args.length == 0) 0
      else args.head + recursiveSum(args.tail: _*)
    }

    //过程，没有等号
    def box(s: String) {
      val border = "-" * s.length + "--\n"
      println(border + "|" + s + "|\n" + border)
    }
    box("aaaaa")
  }
}
