package lectures.part2oop

import playground.{Cinderella, PrinceCharming as Princess} // <-- import package

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Cinderella // 1
  val princess2 = new playground.Cinderella // 2 - fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val princeCharming = new Princess //new PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new java.sql.Date(2018, 5, 4)

  // 2. use aliasing

  // default imports
  // java.lang - String, Objects, Exception
  // Scala - Int, Nothing,Function
  // scala.predef - println, ???
}
