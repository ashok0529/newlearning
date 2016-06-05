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

class MyClass(y:Int){
  val label:String = "This is label in MyClass"
  def apply(x:Int) = x+y
  override def toString = {"Myclass[" + y+"]"}
}

object MainClass{
  def main(args: Array[String]): Unit ={
    println("Hello World")
    val xy = new AnyRef with A
    xy.a;
    println(MainClass.test)
    val my:MyClass  = new MyClass(2)
    println("After applying 3 to " + my.toString + ":" + my(3))
    val x = MainClass(5)
    println("Apply on MainClass returns(x) : " + x)
    val s:String = "Ashok Srinivasan"
    println(FirstName("Ashok","Srinivasan"))

    var testVal:Int =0
    testVal match {
      case TestUnapply(x) => println(x)
      case _ => println("No match")
    }

    testVal =1
    testVal match {
      case TestUnapply(y) => println(y)
      case _ => println("No match")
    }

  }
  def test  = {
    "value of Test"
  }

  def apply(x:Int) = x*2;
  def unapply(z:Int): Option[Int] = if(z%2==0) Some(z/2) else None
}

object FirstName{
  def apply(fname:String,lname:String) = {fname + " " + lname}
  def unapply(name:String): Option[(String,String)] = {
    val splits = name.split("  ");
    if(splits.length == 2) return Some(splits(0),splits(1));
    return None;
  }
}

object TestUnapply{
  def unapply(x:Int): Option[String] = {
    if(x == 1) Some("Hello unapply") else None
  }
}







