package com.miaolegemitong.basics.scala.packageandimport

/**
  * @author miaolegemitong
  */
class PackageVisibility {
  /** 在当前包中可见 */
  private[packageandimport] def description = "An object"

  /** 将可见度延展到上层包 */
  private[basics] def description1 = "An object"
}
