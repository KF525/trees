import org.scalatest.{FlatSpec, Matchers}

class BSTCheckTest extends FlatSpec with Matchers {
  val validTree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Node(18, Empty, Empty), Empty)))
  val invalidTree = Node(10, Node(5, Node(2, Empty, Empty), Node(4, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Node(18, Empty, Empty), Empty)))
  val bst = new BSTCheck

  "isBST" should "return true if the tree is a valid BST" in {
    bst.isBST(validTree) shouldBe true
    bst.isBST(invalidTree) shouldBe false
  }
}
