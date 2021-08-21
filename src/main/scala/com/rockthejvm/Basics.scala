package com.rockthejvm

object Basics extends App {

  // defining a value
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional

  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  // string interpolation using s-quote
  val aInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // last expression is returned
    aLocalValue + 3
  }

   // define a function
  def myFunction(x: Int, y: String): String = x + " " + y

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  // Unit type has no meaningful value
  // void or null in other languages
  // generally the type of SIDE EFFECTS
  println("I love Scala")

  def unitReturner(): Unit = {
    println("I don't love returning Unit.")
  }

  val theUnit = ()
}
