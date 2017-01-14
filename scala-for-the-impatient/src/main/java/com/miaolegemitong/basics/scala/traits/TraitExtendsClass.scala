package com.miaolegemitong.basics.scala.traits

/**
  * @author miaolegemitong
  */
object TraitExtendsClass {
}

/**
  * 扩展了Exception类，Exception类自动成为所有混入LoggedException特质的类的超类
  * 混入此特质的类不能同时继承非Exception子类的其他类
  * */
trait LoggedException extends Exception with Logged {
  def log(): Unit = log(getMessage)
}

class UnhappyException extends LoggedException {
  override def getMessage: String = "argghh!"

  override val abstractField: Int = 10
}