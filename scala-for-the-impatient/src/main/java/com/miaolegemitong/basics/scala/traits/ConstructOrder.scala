package com.miaolegemitong.basics.scala.traits

/**
  * @author miaolegemitong
  */
class ConstructOrder {
}

object ConstructOrder {
  def main(args: Array[String]): Unit = {
    val son = new Son
  }
}

class Parent {
  println("Parent constructs...")
}

class Son extends Parent with SonTrait1 with SonTrait2 {
  println("Son constructs...")
}

trait ParentTrait {
  println("Parent trait constructs...")
}

trait SonTrait1 extends ParentTrait {
  println("Son trait 1 constructs...")
}

trait SonTrait2 extends ParentTrait {
  println("Son trait 2 constructs...")
}