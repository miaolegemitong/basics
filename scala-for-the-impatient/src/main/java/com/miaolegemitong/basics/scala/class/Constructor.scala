package com.miaolegemitong.basics.scala.`class`


class Constructor {
}

/**
  * @author miaolegemitong
  * 辅助构造器
  * 名称为this
  * 每个辅助构造器都必须以一个对先前已定义的其他辅助构造器或主构造器的调用开始
  */
class AuxiliaryConstructor {
  private var name = ""
  private var age = 0

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }
}

/**
  * @author miaolegemitong
  * 主构造器，参数直接放置在类名之后
  * 主构造器会执行类定义中的所有语句
  */
class PrimaryConstructor(val name: String, val age: Int) {
  println("Just constructed an object!")
  def description = name + " is " + age + " years old"
}

/**
  * 不带val或var的主构造器参数参数
  * 如果至少被一个方法所使用，将升格为对象私有字段，相当于private[this] val
  * 如果不被方法使用，该参数将不被保存为字段，仅仅是可以被主构造器中的代码访问的普通参数
  * */
class NoValVarPrimaryConstructor(name: String) {
  def aaa = name
}

/**
  * 私有主构造器，只能通过辅助构造器构造对象
  * */
class PrivatePrimaryConstructor private(val id: Int) {
}