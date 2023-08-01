package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = Tuple2(2, "hello, Scala") // Tuple [int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap = Map[String, Int]()
  val phonebook = Map[String, Int](("Jim", 555), (("Daniel", 79)))
  val phonebook2 = Map[String, Int]("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1)
  // a -> is sugar for (a,b)
  println(phonebook2)

  // map ops
  println(phonebook2.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook2("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filtersKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)

  // mapValues
  println(phonebook.view.mapValues(number => "0245-" + number).toMap)
  // conversioon to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)

  private val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /**
   * 1. what would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900 ?
   *
   * !!! careful with mapping keys
   *
   * overly simplified social network based on maps
   * Person = String
   *    - add a person to the network
   *    - remove
   *    - friend
   *    - unfriend
   *
   *    - number of friends of a person
   *    - person with most friends
   *    - how many people have NO friends
   *    - if there is a social connection between two people (direct or not)
   */
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(network, "Bob", "Mary"))
}
