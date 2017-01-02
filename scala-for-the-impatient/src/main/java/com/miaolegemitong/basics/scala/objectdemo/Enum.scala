package com.miaolegemitong.basics.scala.objectdemo

/**
  * @author miaolegemitong
  * Scala枚举，Value为Enumeration内部类
  * 也可以向Value传入ID、名称或者两者都传
  * 如果不传参，则ID在前一个枚举值基础上加一，从零开始；缺省名称为字段名
  * 枚举对象的类型是Enum.Value，而不是Enum，Enum对象是握有这些值的对象
  * 枚举值的ID可通过id方法返回，名称通过toString方法返回
  */
object Enum extends Enumeration {
  val Red = Value //什么都不传，默认ID从0开始
  val Yellow = Value(10)
  val Green = Value("Name") //ID为11
  val Black = Value(15, "Name1")
}

object Main {
  def main(args: Array[String]): Unit = {
    for (c <- Enum.values) println(c.id + ": " + c.toString) //遍历
    println(Enum(11)) //通过枚举的ID查找枚举值
    println(Enum.withName("Name1")) //通过枚举的名称查找枚举值
  }
}