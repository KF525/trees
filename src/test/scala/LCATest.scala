import org.scalatest.{FlatSpec, Matchers}

class LCATest extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty)))
  val lca = new LCA

  "findLowestCommonAncestorInBST" should "return LCA node" in {
    lca.findLowestCommonAncestorInBST(tree, 2, 7) shouldBe Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty))
    lca.findLowestCommonAncestorInBST(tree, 12, 20) shouldBe Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty))
  }

  it should "return the parent node if a node is a child of the other" in {
    lca.findLowestCommonAncestorInBST(tree, 5, 7) shouldBe Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty))
    lca.findLowestCommonAncestorInBST(tree, 15, 20) shouldBe Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty))
  }

  it should "handle an empty tree" in {
    lca.findLowestCommonAncestorInBST(Empty, 1, 2) shouldBe Empty
  }

  it should "return the root if the nodes are on opposite subtrees" in {
    lca.findLowestCommonAncestorInBST(tree, 5, 15) shouldBe tree
  }

  "findLowestCommonAncestorInBSTAndConfirmNodePresence" should "handle when nodes are not in the tree" in {
    lca.findLowestCommonAncestorInBSTAndConfirmNodePresence(tree, 2,7) shouldBe
      Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty))
  }

  it should "return the parent node if a node is a child of the other" in {
    lca.findLowestCommonAncestorInBSTAndConfirmNodePresence(tree, 5, 7) shouldBe
      Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty))
    lca.findLowestCommonAncestorInBSTAndConfirmNodePresence(tree, 15, 20) shouldBe
      Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty))
  }

  it should "handle an empty tree" in {
    lca.findLowestCommonAncestorInBSTAndConfirmNodePresence(Empty, 1, 2) shouldBe Empty
  }

  it should "return the root if the nodes are on opposite subtrees" in {
    lca.findLowestCommonAncestorInBSTAndConfirmNodePresence(tree, 5, 15) shouldBe tree
  }

  it should "handle values that are not present in tree" in {
    lca.findLowestCommonAncestorInBSTAndConfirmNodePresence(tree, 40, 100) shouldBe Empty
  }
}
