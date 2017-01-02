package com.miaolegemitong.basics.scala.basic

import java.io.IOException
import java.net.{MalformedURLException, URL}

import scala.tools.nsc.interpreter.InputStream

/**
  * @author miaolegemitong
  */
object Exception {
  def main(args: Array[String]): Unit = {
    val url = "http://www.baidu.com"
    var in: InputStream = null
    try {
      in = new URL(url).openStream()
    } catch {
      case _: MalformedURLException => println("Bad URL: " + url)
      case ex: IOException => ex.printStackTrace()
    } finally {
      if (in != null) {
        in.close()
      }
    }
  }
}
