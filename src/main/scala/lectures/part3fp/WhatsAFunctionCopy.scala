package lectures.part3fp

object WhatsAFunctionCopy extends App {
  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  stringToIntConverter("3") + 4

  val added = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = ???
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /**
   *  1. a function which takes 2 strings and concatenates them
   *     3. define a function which takes and int and returns another functions an int
   *    - what's the type of this function
   *    - how to do it
   */

  val concateStrings = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  val supperAdder = new Function[Int, Function[Int, Int]] {
    override def apply(v1: Int): Function[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  println(supperAdder(3)(4)) // curried function

}
