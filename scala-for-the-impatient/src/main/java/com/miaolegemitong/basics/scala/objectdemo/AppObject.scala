package com.miaolegemitong.basics.scala.objectdemo

/**
  * @author miaolegemitong
  * 应用程序对象
  * 1）可以提供main方法
  * 2) 继承App特质，将程序代码放入构造器方法体内
  */
object AppObject {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}

object AppObject1 extends App {
  if (args.length > 0) {
    println("Hello, " + args(0))
  } else {
    println("Hello, World!")
  }
}