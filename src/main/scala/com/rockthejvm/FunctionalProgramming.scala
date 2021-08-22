package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(3); similar to __init__() in python

  /*
    Scala runs on the JVM
    Functional programming:
    - treat functions as first class objects
    - compose functions
    - pass functions as args
    - return functions as results

    To do this, we need FunctionX

   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // returns 24
  simpleIncrementer(23) // invoke class as function
  // roundabout way to define a function

  // function with two args and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", " Scala") // "I love Scala"

  // syntax sugar
//  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
//  val doubler: Int => Int = (x: Int) => 2 * x
  val doubler = (x: Int) => 2 * x
  doubler(4) // 8

  // higher-order functions: take funcs as args / return funcs as results
  val aMappedList = List(1,2,3).map(x = > x + 1) // HOF
  val aFlatMappedlist = List(1,2,3).flatMap { x =>
    List(x, 2 * x)
  } // alt syntax
  val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3)
  val aShortFilteredList = List(1,2,3,4,5).filter(_ <= 3) // _ refers to the passed arg

  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap { x =>
    List("a", "b", "c").map { l =>
      s"$x+$l"
    }
  }

  // for comprehensions
  val altAllPair = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"

  /*
    Collections
   */

  // lists
  val aList = List(1,2,3,4,5)
  // head = first element
  // tail = rest
  val firstEl = aList.head
  val remainingEls = aList.tail
  val prependedList = 0 :: aList // List(0,1,2,3,4,5)
  val extendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val indexing = aSequence(1)

  // vectors: fast Sequences
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val addedSet = aSet + 5 // Set(1,2,3,4,5)
  val removedSet = aSet - 3 // Set(1,2,4)

  // ranges
  val aRange = 1 to 1000 // does not actually store every value in mem, but can act as if it does
  val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6,...,2000)

  // tuples = groups of values of various types
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 23235),
    "Jane" -> 234234 // ("Jane" , 234234)
  )

}
