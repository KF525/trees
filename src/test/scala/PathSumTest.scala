import org.scalatest.{FlatSpec, Matchers}

class PathSumTest extends FlatSpec with Matchers{

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(8, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Node(18, Empty, Empty), Empty)))
  val pathSum = new PathSum


  "hasPathSum" should "return true if the path sum equals target" in {
    pathSum.hasPathSum(17, tree) shouldBe true
  }

  it should "return false if th none of the paths equal target" in {
    pathSum.hasPathSum(125, tree) shouldBe false
    pathSum.hasPathSum(19, tree) shouldBe false
  }
}
