package lectures.part2oop

object OOPBasics extends App {
  val person = new Person("John", 26)
  println(person.x)

  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.getAuthorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

// class parameters are NOT FIELDS

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullname = s"$firstName $surname"
}

class Novel(val name: String, val yearOfRelease: Int, val writer: Writer) {
  def getAuthorAge: Int = yearOfRelease - writer.year

  def isWrittenBy(writer: Writer): Boolean = writer == this.writer

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, writer)
}

class Counter(val value: Int = 0) {
  def increment = {
    println("incrementing")
    new Counter(value + 1) // immutability
  }

  def decrement = {
    println("decrementing")
    new Counter(value - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment.increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount - 1)
  }

  def print = println(value)
}

/**
 * Novel and a Writer class
 * Writer: first name, surname, year
 *  - method fullname
 *
 * Novel: name, year of release, author
 *  - authorAge
 *  - isWrittenBy(author)
 *  - copy (new year of release) = new instance of Novel
 *
 * Counter class
 *  - receives and int value
 *  - method current count
 *  - method to increment/decrement => new Counter
 *  - overload inc/dec to receive an amount
 */
