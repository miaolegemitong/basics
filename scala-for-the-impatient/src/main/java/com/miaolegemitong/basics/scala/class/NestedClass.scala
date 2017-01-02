package com.miaolegemitong.basics.scala.`class`

import scala.collection.mutable.ArrayBuffer

/**
  * @author miaolegemitong
  */
class NestedClass {
  /**
    * 每个NestedClass实例都有自己的Nested类，不同两个对象的Nested类是不同的类
    * 如果想要各个实例用一个内部类，可以将内部类声明在类的半生对象中，或者使用类型投影NestedClass#Nested
    * */
  class Nested(val name: String) {
    val value = new ArrayBuffer[Nested]()
  }

  private val nesteds = new ArrayBuffer[Nested]()

  def join(name: String) = {
    val n = new Nested(name)
    nesteds += n
    n
  }
}
