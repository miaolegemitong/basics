package com.miaolegemitong.basics.scala.objectdemo

/**
  * @author miaolegemitong
  * 单例对象，对象的构造器在该对象第一次被使用时调用
  * 如果一个对象从未被使用，那么其构造器也不会被执行
  * 本质上可以拥有类的所有特性，但不能提供构造器参数
  */
object SingletonObject {
  private var value = 0

  def newUniqueNumber() = { value += 1; value }
}
