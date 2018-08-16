import org.scalatest.{FlatSpec, Matchers}

class KthElementTest  extends FlatSpec with Matchers {

  val tree = NodeC(6, NodeC(4, NodeC(2, EmptyC, EmptyC, 1), EmptyC, 2), NodeC(10, NodeC(8, EmptyC, EmptyC, 1), NodeC(15, EmptyC, EmptyC, 1), 3), 5)
  val kthElement = new KthElement

  "kthSmallestElement" should "return the root immediately if left children is one less than k" in {
    val node = kthElement.kthSmallestElement(tree, 3)
    node.asInstanceOf[NodeC[Int]].data shouldBe 6
  }

  it should "correctly handle the smallest/most left element in tree and return 2" in {
    val node = kthElement.kthSmallestElement(tree, 1)
    node.asInstanceOf[NodeC[Int]].data shouldBe 2
  }

  it should "correctly handle nodes in the left subtree and return 4" in {
    val node = kthElement.kthSmallestElement(tree, 2)
    node.asInstanceOf[NodeC[Int]].data shouldBe 4
  }

  it should "correctly handle nodes in the right subtree and return 8" in {
    val node = kthElement.kthSmallestElement(tree, 4)
    node.asInstanceOf[NodeC[Int]].data shouldBe 8
  }

  it should "correctly handle nodes in the right subtree and return 10" in {
    val node = kthElement.kthSmallestElement(tree, 5)
    node.asInstanceOf[NodeC[Int]].data shouldBe 10
  }

  it should "correctly handle nodes in the right subtree and return 15" in {
    val node = kthElement.kthSmallestElement(tree, 6)
    node.asInstanceOf[NodeC[Int]].data shouldBe 15
  }

  it should "handle an empty tree or invalid kth element" in {
    kthElement.kthSmallestElement(tree, 8) shouldBe EmptyC
    kthElement.kthSmallestElement(EmptyC, 1) shouldBe EmptyC
  }
}
