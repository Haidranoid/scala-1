package lectures.part4pm

object BracelessSyntax {

  // if - expressions
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  // java-style
  val anIfExpression_v2 =
    if (2 > 3) {
      "bigger"
    } else {
      "smaller"
    }

    // compact
    val anIfExpression_v3 =
      if (2 > 3) "bigger"
      else "smaller"

    //  scala 3
    val anIfExpression_v4 =
      if 2 > 3 then
        "bigger" // higher identation than the if part
      else
        "smaller"

    val anIfExpression_v5 =
      if 2 > 3 then
        val result = "bigger"
        result
      else
        val result = "smaller"
        result

    // scala 3 one-liner
    val anIfExpression_v6 = if 2 > 3 then "bigger" else "smaller"

    // for comprehensions
    val aForComprehension = for {
      n <- List(1, 2, 3)
      s <- List("black", "white")
    } yield s"$n$s"
}
