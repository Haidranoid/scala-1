package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)

  // map
  println(list.map(x => x + 1))
  println(list.map(_ + " is a number"))

  // filter
  def predicate(x: Int): Boolean = x % 2 == 0

  val predicate2: Int => Boolean = x => x % 2 == 0
  println(list.filter(predicate))
  println(list.filter(predicate2))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /**
   * 1. MyList supports for comprehensions ?
   *   A small collections fo at most ONE element - Maybe[+T]
   */
}
