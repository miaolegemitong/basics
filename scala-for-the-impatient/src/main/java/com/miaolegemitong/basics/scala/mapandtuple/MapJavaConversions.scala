package com.miaolegemitong.basics.scala.mapandtuple

import scala.collection.JavaConversions.mapAsScalaMap //Java Map转换为Scala Map
import scala.collection.JavaConversions.propertiesAsScalaMap //Java Properties转换为Scala Map
import scala.collection.JavaConversions.mapAsJavaMap //Scala Map转换为Java Map
import java.awt.font.TextAttribute._

/**
  * @author miaolegemitong
  */
object MapJavaConversions {
  def main(args: Array[String]): Unit = {
    val scores: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]()

    val properties: scala.collection.Map[String, String] = System.getProperties

    val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
    val font = new java.awt.Font(attrs)
  }
}
