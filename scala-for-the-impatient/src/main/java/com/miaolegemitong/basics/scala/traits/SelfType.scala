package com.miaolegemitong.basics.scala.traits

/**
  * @author miaolegemitong
  */
object SelfType {
}

/**
  * 自身类型
  * 只能被混入Exception类的子类
  * */
trait LoggedException1 extends Logged {
  this: Exception =>
    def log() { log(getMessage) }
}

/**
  * 自身类型处理结构类型
  * 只能被混入任何拥有getMessage方法的类
  * */
trait LoggedException2 extends Logged {
  this: { def getMessage(): String } =>
    def log() { log(getMessage()) }
}