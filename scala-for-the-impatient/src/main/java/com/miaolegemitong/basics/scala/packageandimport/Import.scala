package com.miaolegemitong.basics.scala.packageandimport

/** 引入包内所有成员 */
import com.miaolegemitong._
/** 单独引入某个类 */
import com.miaolegemitong.Utils1
/** 引入某个类内所有成员 */
import com.miaolegemitong.Utils1._
/** 引入包中的几个成员 */
import com.miaolegemitong.basics.scala.packageandimport.{FileHeadPackage, PackageVisibility}
/** 重命名选取器选到的成员 */
import java.util.{HashMap => JavaHashMap}
/** 隐藏某个成员，在需要引入所有其他成员时使用 */
import java.util.{HashMap => _, _}

/**
  * @author miaolegemitong
  */
class Import {
  /** import语句可以出现在任何地方，并不限于文件顶部 */
  import com.miaolegemitong.basics.Utils
}
