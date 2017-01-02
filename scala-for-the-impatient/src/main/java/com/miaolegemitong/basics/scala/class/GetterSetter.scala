package com.miaolegemitong.basics.scala.`class`

import scala.beans.BeanProperty

/**
  * @author miaolegemitong
  */
class GetterSetter {
  /** 字段默认公有
    * 编译生成的面向JVM的类，其中有一个私有的age字段以及公有的getter和setter方法
    * getter名为age，setter名为age_= */
  var value = 0

  /** private[this]，对象私有字段，不生成getter和setter，即不能访问同类型另一个对象的此字段 */
  private[this] val objectPrivate = 1

  /** private，类私有字段，会生成私有的getter和setter方法 */
  private val classPrivate = 2

  /** 使用val定义字段，会生成私有的final字段和一个公有的getter方法，但没有setter */
  val timestamp = new java.util.Date

  /** 不能实现带有setter但不带getter的属性 */
}

/**
  * Bean属性，生成getXXX和setXXX方法
  * */
class Person {
  /**
    * 会生成四个方法：name: String, name_=(newValue: String): Unit, getName(): String, setName(newValue: String): Unit
    * */
  @BeanProperty var name: String = _
}
