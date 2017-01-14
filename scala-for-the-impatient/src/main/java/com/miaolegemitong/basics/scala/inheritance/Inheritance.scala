package com.miaolegemitong.basics.scala.inheritance

/**
  * @author miaolegemitong
  */
class Inheritance {
}

object Inheritance {
  def main(args: Array[String]): Unit = {
    val manager = new Manager("xxx", 10)
    /** 检查maneger的类型是否为Employee或Employee的子类 */
    println(manager.isInstanceOf[Employee])
    /** 检查manager的类型是否为Employee但又不是Employee的子类 */
    println(manager.getClass == classOf[Employee])
    /** 使用模式匹配检查类型 */
    manager match {
      case employee: Employee => {} //将employee作为Employee处理
      case _ => //employee不是Employee
    }

    val c1: Creature = new Ant1
    println(c1.env.length) // 0

    val c2: Creature = new Ant2
    println(c2.env.length) // 2
  }
}

/** 抽象类 */
abstract class Person(name: String, age: Int) {
  /** final修饰字段时和Java不同，表示字段不可以被子类重写；但修饰类或者方法时和Java相同 */
  final val a = 1

  /** protected，受保护字段和方法，这样的成员可以被任何子类访问，但不能从其他位置看到 */
  protected val b = 2

  /** protected[this]，将访问权限定在当前的对象 */
  protected[this] val c = 3

  /** 抽象方法 */
  def id: Int

  /** 抽象字段，没有初始值，带有抽象getter方法，生成的Java类不带此字段 */
  val id1: Int

  /** 抽象字段，带有抽象的getter和setter方法，生成的Java类不带此字段 */
  var id2: Int
}

/**
  * 超类的构造
  * 辅助构造器必须以对先前定义的辅助构造器或主构造器的调用开始
  * 导致辅助构造器不可能直接调用超类的构造器
  * 所以，只有主构造器可以调用超类的构造器
  * 不能使用super(params)这种方式
  * Scala类可以扩展Java类，但它的主构造器必须调用Java超类的某一个构造方法
  * */
class Employee(name: String, age:Int, val salary: Double = 0.0) extends Person(name, age) {
  /** 重写非抽象方法必须使用override修饰 */
  override def toString: String = super.toString + "[salary=" + salary + "]"

  override val b = 4

  /** 重写父类的抽象方法，不需要使用override关键字 */
  def id: Int = name.hashCode

  /** 重写父类的抽象字段，不需要使用ovverride关键字 */
  val id1: Int = 10
  var id2: Int = 10
}

class Manager(name: String, age: Int) extends Employee(name, age, 1000.0) {
}

/**
  * 提前定义
  * 在超类的构造器中调用方法时，被调用的方法可能被子类重写，因此可能并不会按照预期执行
  * */
class Creature {
  val range = 10
  /** 依赖于子类的range的getter方法 */
  val env = new Array[Int](range)
}

class Ant1 extends Creature {
  /**
    * 构造过程：
    * 1、先调用Creature的构造器
    * 2、Creature的构造器将range字段设置为10
    * 3、Creature的构造器为了初始化env数组，调用range()方法
    * 4、range()方法被重写以输出（还未初始化的）Ant1类的range字段值
    * 5、range方法返回0
    * 6、env被设置为长度为0的数组
    * 7、Ant1构造器继续执行，将range字段设置为2
    * */
  override val range = 2
}

/**
  * 提前定义语法
  * 在超类的构造器执行之前初始化子类的val字段
  * */
class Ant2 extends {
  override val range = 2
} with Creature