import org.scalatest.{FlatSpec, Matchers}

class LevelCountTest extends FlatSpec with Matchers{

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Node(18, Empty, Empty), Empty)))
  val levelCount = new LevelCount

  "countNodes" should "return the number of nodes on agiven level" in {
    levelCount.countNodes(2, tree) shouldBe 4
    levelCount.countNodes(3, tree) shouldBe 1
  }

  it should "handle invalid inputs" in {
    levelCount.countNodes(7, tree) shouldBe 0
    levelCount.countNodes(-1, tree) shouldBe 0
  }
}
