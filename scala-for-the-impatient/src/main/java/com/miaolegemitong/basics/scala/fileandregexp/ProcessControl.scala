package com.miaolegemitong.basics.scala.fileandregexp

import java.io.File
import java.net.URL

import sys.process._

/**
  * @author miaolegemitong
  */
object ProcessControl {
  def main(args: Array[String]): Unit = {
    /** 执行成功返回0，否则返回对应错误码 */
    val intResult = "ls -al /" !

    println(intResult)

    /** 返回字符串 */
    val strResult = "ls -al /" !!

    println(strResult)

    /** 管道 */
    "ls -al /" #| "grep Applications" !

    /** 将输出结果重定向到文件 */
    "ls -al /" #> new File("output.txt") !

    /** 追加输出结果到文件末尾 */
    "ls -al /" #>> new File("output.txt") !

    /** 把文件内容作为输入 */
    "grep sec" #< new File("input.txt") !

    /** 从URL重定向输入 */
    "grep Scala" #< new URL("http://www.scala-lang.org/") !

    /** 调用Process对象的apply方法来构造ProcessBuilder */
    val p = Process("ls -al", new File("/"), ("LANG", "en_US"))
    val q = Process("ls -al", new File("/"), ("LANG", "en_US"))

    /** 执行ProcessBuilder */
    p !

    /** 如果p成功，则执行q */
    p #&& q

    /** 如果p不成功，则执行q */
    p #|| q
  }
}
