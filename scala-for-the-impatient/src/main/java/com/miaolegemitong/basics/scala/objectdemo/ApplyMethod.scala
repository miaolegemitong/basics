package com.miaolegemitong.basics.scala.objectdemo

/**
  * @author mitong
  */
class ApplyMethod private(val id: Int, initialBalance: Double) {
  private var balance = initialBalance
}

object ApplyMethod { // 伴生对象
  private var lastNumber = 0

  def newUniqueNumber() = { lastNumber += 1; lastNumber }

  def apply(initialBalance: Double): ApplyMethod = new ApplyMethod(newUniqueNumber(), initialBalance)

  def main(args: Array[String]): Unit = {
    val applyMethod1 = new ApplyMethod(10, 1000.0) // 调用类的主构造器
    val applyMethod2 = ApplyMethod(1000.0) // 调用对象的apply方法
  }
}