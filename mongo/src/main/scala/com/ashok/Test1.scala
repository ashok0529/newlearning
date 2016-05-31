package com.ashok

/**
  * Created by ashok on 5/30/2016.
  */
trait BaseTrait {
  def a = {
    println("This is BaseTrait")
  }
}

trait A extends BaseTrait {
  override def a = {
    println("This is trait A")
    super.a

  }

}

object MainClass{

  def main(args: Array[String]): Unit ={
    println("Hello World")
    val xy = new AnyRef with A
    xy.a
  }
}
