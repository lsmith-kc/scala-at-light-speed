package com.rockthejvm

object ObjectOrientation extends App {

  class Animal {
    val age: Int = 0

    def eat() = println("I'm eating.")
  }

  // instantiation
  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal
  val aDog = new Dog("Lassie")

  // constructor arguments are not fields
  // use val before constructor argument to convert to field

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // public my default, protected or private to restrict
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  // can leave everything un-implemented
  // can technically implement too, but not typical
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(s"I am eating you, $animal!")

    override def eat(): Unit = super.eat()

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("EATINGG")
  }

  // singletons
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 2525423

    def mySpecialMethod(): Int = 25

    def apply(x: Int) = x + 1
  }

  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal { // companion object -- same name as a class
    // companions can access eachothers private values and methods
    val canLiveIndefinitely = false // "static" -- doesn't depend on specific instantiation
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" field / methods

  /*
    case classes = lightweight data structures with some boilerplate
    similar to Dataclasses in python
    - sensible equals methods and hash code
    - serialization
    - companion with apply (can invoke directly without keyword 'new')
    - pattern matching
   */
  case class Person(name: String, age: Int)

  // may be constructed without keyword 'new'
  val bob = Person("Bob", 54)

  // exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e : Exception => "some problem"
  } finally {
    // cleanup stuff from the try block
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def rest: MyList[T]
  }

  // making generic concrete at instantiation
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3) -- companion object
  val first = aList.head
  val rest = aList.rest
}
