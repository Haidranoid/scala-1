package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
   * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
   * 2. Factorial function1 * 2 * 3 * .. * n
   * 3. A fibonacci function
   *    f(1) = 1
   *    f(2) = 1
   *    f(n) = f(n - 1) + f(n - 2)
   * 4. Test if a number is prime.
   *
   */

  def greetings(name: String, age: Int): Unit =
    println(s"Hi, my name is $name and Iam $age years old")

  greetings("Eduardo", 26)


  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println("factorial of 5 is => " + factorial(5)) // 120
  println("factorial of 3 is => " + factorial(3)) // 3
  println("factorial of 1 is => " + factorial(1)) // 1

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  val value = fibonacci(8)
  println(value)

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
