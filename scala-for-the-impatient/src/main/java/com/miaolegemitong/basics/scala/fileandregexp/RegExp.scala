package com.miaolegemitong.basics.scala.fileandregexp

/**
  * @author miaolegemitong
  */
object RegExp {
  def main(args: Array[String]): Unit = {
    val str = "99 bottles, 98 bottles"

    val numPattern = "[0-9]+".r
    /** 有反斜杠的正则表达式最好使用""" */
    val wsnumwsPattern = """\s+[0-9]+\s+""".r
    /** 返回遍历所有匹配项的迭代器 */
    for (matchString <- numPattern.findAllIn(str)) {
      println(matchString)
    }

    /** 返回第一个匹配项，得到Option[String] */
    val first = wsnumwsPattern.findFirstIn(str)
    println(first.getOrElse(""))

    /** 检查字符串的开始部分是否能匹配，返回Option[String] */
    println(numPattern.findPrefixOf(str))
    println(wsnumwsPattern.findPrefixOf(str))

    /** 替换匹配项 */
    println(numPattern.replaceFirstIn(str, "XX"))
    println(numPattern.replaceAllIn(str, "XX"))

    /** 正则表达式组 */
    val numitemPattern = "([0-9]+) ([a-z]+)".r
    val numitemPattern(num, item) = "99 bottles"
    println(num)
    println(item)

    for (numitemPattern(num, item) <- numitemPattern.findAllIn(str)) {
      println(num + "\t" + item)
    }
  }
}
