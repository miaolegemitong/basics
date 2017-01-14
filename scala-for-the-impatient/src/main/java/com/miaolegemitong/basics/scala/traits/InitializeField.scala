package com.miaolegemitong.basics.scala.traits

import java.io.PrintStream

/**
  * @author miaolegemitong
  */
class InitializeField {
}

object InitializeField {
  def main(args: Array[String]): Unit = {
    /**
      * aaa实际上是扩展自InitializeField类并混入FileLogger特质的匿名类的子类
      * FileLogger先进行构造，在这个子类构造之前就已经抛出了空指针异常
      **/
    //    val aaa = new InitializeField with FileLogger {
    //      /**
    //        * aaa实际上是扩展自InitializeField类并混入FileLogger特质的匿名类的子类
    //        * FileLogger先进行构造，在这个子类构造之前就已经抛出了空指针异常
    //        * */
    //      val filename: String = "log.txt"
    //    }
    /** 解决方法一：提前定义 */
    val bbb = new {
      val filename = "log.txt"
    } with InitializeField with FileLogger

    /** 解决办法二，将FileLogger中的out属性声明为lazy字段，但会影响效率 */
  }
}

trait FileLogger extends Logger {
  val filename: String
  val out = new PrintStream(filename)

  override def log(msg: String): Unit = {
    out.println(msg)
    out.flush()
  }
}