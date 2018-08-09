import org.scalatest.{FlatSpec, Matchers}

class PostOrderTest extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty)))
  val postOrder = new PostOrder

  "traverse" should "complete a pre order traversal" in {
    postOrder.traverse(tree) shouldBe "27512201510"
  }

  it should "handle an empty tree" in {
    postOrder.traverse(Empty) shouldBe ""
  }
}
