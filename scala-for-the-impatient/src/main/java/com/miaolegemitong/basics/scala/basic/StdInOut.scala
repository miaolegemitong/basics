package com.miaolegemitong.basics.scala.basic

import scala.io.StdIn

/**
  * @author miaolegemitong
  */
object StdInOut {
  def main(args: Array[String]) {
    val name = StdIn.readLine("Your name: ")
    print("Your age: ")
    val age = StdIn.readInt()
    printf("Hello, %s! Next year, you will be %d.\n", name, age + 1)
  }
}
