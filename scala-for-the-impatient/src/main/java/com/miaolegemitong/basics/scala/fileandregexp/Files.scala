package com.miaolegemitong.basics.scala.fileandregexp

import java.io.{File, FileInputStream, PrintWriter}

import scala.io.Source

/**
  * @author miaolegemitong
  */
object Files {
  def main(args: Array[String]): Unit = {
    val path = Files.getClass.getResource("/test.txt").getPath
    val source = Source.fromFile(path, "UTF-8")
    /** 读取行 */
    val lineIterator = source.getLines()
    for (line <- lineIterator) {
      println(line)
    }

    /** 读取字符，Source类扩展自Iterator[Char]，可以直接迭代 */
    for (c <- source) {
      print(c + " ")
    }
    println()

    /** 要关闭source */
    source.close()

    /** 读取URL */
    val source1 = Source.fromURL("http://www.baidu.com", "UTF-8")
    source1.close()

    /** 从字符串读取，用来调试 */
    val source2 = Source.fromString("Hello, World!")
    source2.close()

    /** 从标准输入读取 */
    val source3 = Source.stdin
    source3.close()

    /** 读取二进制文件，需要使用Java类库 */
    val file = new File("fileName")
    val in = new FileInputStream(file)
    val bytes = new Array[Byte](file.length().toInt)
    in.read(bytes)
    in.close()

    /** 写入文本文件，使用Java类库 */
    val out = new PrintWriter("out.txt")
    for (i <- 1 to 100) out.println(i)
    out.close()
  }
}
