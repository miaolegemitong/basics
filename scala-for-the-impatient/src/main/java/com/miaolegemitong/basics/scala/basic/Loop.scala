package com.miaolegemitong.basics.scala.basic

/**
  * @author miaolegemitong
  */
object Loop {
  def main(args: Array[String]) {
    var n = 10
    var r = 1
    while (n > 0) {
      r = r * n
      n -= 1
    }
    println(r)

    val x = 10
    var y = 1
    for (i <- 1 to x) {
      y = y * i
    }
    println(y)


    val s = "Hello"
    var sum = 0
    for (i <- 0 until s.length) {
      sum += s(i)
    }
    println(sum)

    sum = 0
    for (ch <- s) {
      sum += ch
    }
    println(sum)

    //多个生成器形成多重循环
    for (i <- 1 to 3; j <- 1 to 3) {
      print((i * 10 + j) + " ")
    }
    println()

    //每个生成器都可以带一个守卫（if开头的Boolean表达式）
    for (i <- 1 to 3 if i != 2; j <- 1 to 3 if i != j) {
      print((i * 10 + j) + " ")
    }
    println()

    //可以使用人亿多的定义，引入可以在循环中使用的变量
    for (i <- 1 to 3; from = 4 - i; j <- from to 3) {
      print((i * 10 + j) + " ")
    }
    println()

    //for推导式，循环构造集合,循环体以yield开始
    val set = for (i <- 1 to 10) yield i.toString
    println(set.getClass)
    println(set)
    //for推导式生成的集合与第一个生成器是类型兼容的
    val ss = for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
    println(ss.getClass)
    println(ss)
    val cs = for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
    println(ss.getClass)
    println(ss)
  }
}
