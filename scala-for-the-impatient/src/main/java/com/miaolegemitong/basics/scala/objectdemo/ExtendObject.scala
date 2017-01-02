package com.miaolegemitong.basics.scala.objectdemo

/**
  * @author miaolegemitong
  */
abstract class ExtendObject(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothingObject extends ExtendObject("Do nothing") {
  override def undo() {}

  override def redo() {}
}