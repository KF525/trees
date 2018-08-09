import org.scalatest.{FlatSpec, Matchers}

class KthElementTest  extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty)))
  val kthElement = new KthElement

  "kthSmallestElement" should "return the kth element in a tree" in {

  }
}
