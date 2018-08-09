import org.scalatest.{FlatSpec, Matchers}

class PreOrderTest extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty)))
  val preOrder = new PreOrder

  "traverse" should "complete a pre order traversal" in {
    preOrder.traverse(tree) shouldBe "10527151220"
  }

  it should "handle an empty tree" in {
    preOrder.traverse(Empty) shouldBe ""
  }
}
