package lectures.part2oop

object GenericsCopy extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
  }



  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  class Bird

  // if Cat extends animal, does a list of Cats also extends a list of animal

  // yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???

  // no -INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // hell no. CONTRAVARIANCE
  class TrainerList[-A]

  val trainerList: TrainerList[Cat] = new TrainerList[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // A extends Animal

  val cage = new Cage(new Dog)
}
