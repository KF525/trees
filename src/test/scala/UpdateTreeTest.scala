import org.scalatest.{FlatSpec, Matchers}

class UpdateTreeTest extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Node(18, Empty, Empty), Empty)))
  val updateTree = new UpdateTree

  "addNode" should "return a new tree with the additional node" in {
    val expectedTree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Node(18, Node(17, Empty, Empty), Empty), Empty)))
    updateTree.addNode(17, tree) shouldBe expectedTree
  }

  "deleteNode" should "return a new tree without the unawanted node" in {

  }
}
