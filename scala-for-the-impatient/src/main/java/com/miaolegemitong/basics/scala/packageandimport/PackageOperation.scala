/**
  * @author miaolegemitong
  * 使用嵌套结构定义包，com.aaa.bbb.CCC类不一定位于com/aaa/bbb目录下
  */
package com {
  package miaolegemitong {
    object Utils1 {
      def print() { println("Hello, World1!") }
    }
    package basics {
      object Utils {
        def print() { println("Hello, World!") }
      }

      package scala {
        package  packageandimport {
          class PackageOperation {
            /** 所有父包的内容都在作用域内 */
            def print() { Utils.print() }

            def print1() { Utils1.print() }
          }
        }
      }
    }
  }
}

/** 一个Scala文件可以为多个包贡献内容 */
package test {
  class Test {

  }
}

/** 串联式包语句 */
package test1.test2.test3 {
  /** test1和test1.test2的成员在Test类中不可见 */
  package test4 {
    class Test {

    }
  }
}