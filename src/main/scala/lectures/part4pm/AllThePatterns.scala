package lectures.part4pm

import exercises.MyList

import scala.runtime.Nothing$

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"


  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ => ()
  }

  // 2.2 variable
  val matchAvariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchAtuple = aTuple match
    case (1, 1) => ()
    case (something, 2) => s"I've found $something"


  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match
    case (_, (2, v)) =>

  // PMs can be NESTED!

  // 4 - case classes - constructor pattern
  // 5
  // 6
  // 7
  // 8
  
}
