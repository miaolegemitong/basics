package com.miaolegemitong.basics.scala

/**
  * @author miaolegemitong
  */
package object inheritance {
  /**
    * Scala继承层级
    * Any类是整个继承层级的根结点
    * Any类中定义了isInstanceOf、asInstanceOf方法，以及用于相等性判断和哈希码的方法
    * AnyVal继承自Any，Java中基本类型相对应的类，以及Unit类型，都扩展自AnyVal
    * AnyVal并没有追加任何方法，只是所有值类型的一个标记
    * 所有其他类都是AnyRef的子类，AnyRef是Java或.NET虚拟机中Object类的同义词
    * AnyRef类追加了来自Object类的监视方法wait和notify/notifyAll，同时提供了一个带函数参数的方法synchronized
    * 所有Scala类都实现ScalaObject这个标记接口，这个接口没有定义任何方法
    * Null是所有引用类型的子类型，唯一实例是null，可以将null赋值给任何引用，但不能赋值给值类型的变量
    * Nothing是所有类型的字类型，没有实例，对于泛型结构时常有用
    * */
}
