import org.scalatest.{FlatSpec, Matchers}

class InOrderTest extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty)))
  val inOrder = new InOrder

  "traverse" should "complete a pre order traversal" in {
    inOrder.traverse(tree) shouldBe "25710121520"
  }

  it should "handle an empty tree" in {
    inOrder.traverse(Empty) shouldBe ""
  }
}
