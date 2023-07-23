package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length)
  // this ^^ will crash with NPE

  // 1. throwing exceptions
  //val aWeirdValue = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you !")
    else 42

  try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => println("caught a Run time exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception
}
