package com.miaolegemitong.basics.scala.array

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable
import scala.collection.JavaConversions.bufferAsJavaList //将ArrayBuffer隐式转换为java.util.ArrayList
import scala.collection.JavaConversions.asScalaBuffer //将java.util.ArrayList隐式转换为Buffer

/**
  * @author miaolegemitong
  */
object JavaConversions {
  def main(args: Array[String]): Unit = {
    val command = ArrayBuffer("ls", "-al", "/Users/milton")
    val pb = new ProcessBuilder(command)

    val cmd: mutable.Buffer[String] = pb.command()
  }
}
