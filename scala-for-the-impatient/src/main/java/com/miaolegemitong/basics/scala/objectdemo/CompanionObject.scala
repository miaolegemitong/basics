package com.miaolegemitong.basics.scala.objectdemo

/**
  * @author miaolegemitong
  * 伴生对象，用于创建既有实例方法又有静态方法的类
  * 类和它的伴生对象可以相互访问私有特性
  * 类和它的伴生对象必须存在于同一个源文件中
  */
class CompanionObject {
  /**
    * 伴生对象并不在类的作用域中，不能直接调用方法，必须使用<伴生对象名>.<方法名>
    * */
  val id = CompanionObject.newUniqueNumber()

  private var balance = 0.0

  def deposit(amount: Double) { balance += amount }
}

object CompanionObject { // 伴生对象
  private var lastNumber = 0

  private def newUniqueNumber() = { lastNumber += 1; lastNumber }
}