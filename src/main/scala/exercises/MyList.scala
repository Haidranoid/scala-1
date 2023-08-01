package exercises

abstract class MyList[+A] {
  /**
   * head = first element of the list
   * tail = remainder of the list
   * isEmpty = is this list empty
   * add(int) => new list with this element added
   * toString => a string representation of the list
   */
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](n: B): MyList[B]

  def printElement: String

  override def toString: String = "[" + printElement + "]"

  // hofs
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipwith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](n: B): MyList[B] = new LinkedList(n, Empty)

  override def printElement: String = ""

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int) = Empty

  override def zipwith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty
  }
}

class LinkedList[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](n: B): MyList[B] = new LinkedList(n, this)

  override def printElement: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElement}"

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new LinkedList(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new LinkedList(x, sortedList)
      else new LinkedList(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipwith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new LinkedList(zip(h, list.head), t.zipwith(list.tail, zip))
  }
}

object ListTest extends App {
  val list = new LinkedList(1, new LinkedList(2, new LinkedList(3, Empty)))
  /*println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)

   */
  val listOfIntegers: MyList[Int] = new LinkedList(1, new LinkedList(2, new LinkedList(3, Empty)))
  val listOfStrings: MyList[String] = new LinkedList("Hello", new LinkedList("Scala", Empty))

  println(listOfStrings.toString)
  println(listOfStrings.toString)

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))
}
