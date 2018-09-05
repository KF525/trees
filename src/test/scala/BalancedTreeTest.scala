import org.scalatest.{FlatSpec, Matchers}

class BalancedTreeTest extends FlatSpec with Matchers {
  val balancedTree = new BalancedTree
  val tree = Node(10, Node(5, Empty, Empty), Node(15, Empty, Empty))
  val imbalancedTree = Node(10, Node(5, Empty, Empty), Node(15, Node(14, Node(13, Node(12, Empty, Empty), Empty), Empty), Empty))

  "isBalanced" should "" in {
    balancedTree.isBalanced(tree) shouldBe true
    balancedTree.isBalanced(imbalancedTree) shouldBe false
  }
}
