package com.miaolegemitong.basics.scala.traits

/**
  * @author miaolegemitong
  */
class Traits {

}

trait Logger {
  /** 特质中未被实现的方法默认就是抽象方法，不需要使用abstract关键字 */
  def log(msg: String)

  /** 当作富接口使用，定义有具体实现的方法，调用抽象方法 */
  def info(msg: String) { log("INFO: " + msg) }

  def warn(msg: String) { log("WARN: " + msg) }

  def severe(msg: String) { log("SEVERE: " + msg) }
}

/**
  * 需要继承的特质不止一个，用with关键字
  * 所有Java接口都可以作为Scala特质使用
  * */
class ConsoleLogger extends Logger with Cloneable with Serializable {
  /** 重写特质方法，不需要使用override关键字 */
  def log(msg: String) {
    println(msg)
  }
}

/** 带有实现的方法的特质 */
trait ConsoleLogger1 {
  def log(msg: String) { println(msg) }
}

class B extends ConsoleLogger1 {
  def print(msg: String) { log(msg) }
}

object Main {
  def main(args: Array[String]): Unit = {
    /** 带有特质的对象 */
    val aaa = new Traits with ConsoleLogger1
    aaa.log("xxx")
    /** 不同对象可以混入不同的特质 */
    val bbb = new Traits with Logger {
      override def log(msg: String): Unit = {}
    }

    /**
      * 叠加在一起的特质，super.log方法调用的事特质层级中的下一个特质
      * 特质从最后一个开始被处理
      * */
    val ccc = new Traits with ConsoleLogger2 with TimestampLogger with ShortLogger {
      /** 重写特质的抽象字段，可以不用override关键字 */
      val abstractField: Int = 0
    }
    ccc.log("12345678901234567890")
    val ddd = new Traits with ConsoleLogger2 with ShortLogger with TimestampLogger {
      val abstractField: Int = 0
    }
    ddd.log("12345678901234567890")

    val eee = new Traits with Logger {
      /** 特质中未被实现的方法默认就是抽象方法，不需要使用abstract关键字 */
      override def log(msg: String): Unit = { println(msg) }
    }
    eee.info("xxx")
  }
}

trait Logged {
  /** 特质中的抽象字段，必须在具体的子类中重写 */
  val abstractField: Int
  def log(msg: String) {}
}

trait ConsoleLogger2 extends Logged {
  override def log(msg: String): Unit = {
    println(msg)
  }
}

trait TimestampLogger extends Logged {
  override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends Logged {
  /** 特质中的具体字段，会被简单地添加到任何混入此特质的类，而不是继承此字段 */
  val maxLength = 15
  override def log(msg: String): Unit = {
    super.log(if (msg.length <= maxLength) msg else msg.substring(0, maxLength -3) + "...")
  }
}

trait TimestampLogger1 extends Logger {
  /** 在特质中重写抽象方法 */
  abstract override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}