import org.scalatest.{FlatSpec, Matchers}

class AggregateNodesTest extends FlatSpec with Matchers {

  val tree = Node(10, Node(5, Node(2, Empty, Empty), Node(7, Empty, Empty)), Node(15, Node(12, Empty, Empty), Node(20, Empty, Empty)))
  val aggregateNodes = new AggregateNodes

  "sumNodes" should "return total of node data values" in {
    aggregateNodes.sumNodes(tree) shouldBe 71
  }

  "countNodes" should "return the total number of nodes in the tree" in {
    aggregateNodes.countNodes(tree) shouldBe 7
  }

  "returnNodeAverage" should "return the sum divided by total count" in {
    aggregateNodes.returnNodeAverage(tree) shouldBe 10
  }

  "sumNodesWithCondition" should "return the total of leaf data values" in {
    aggregateNodes.sumNodesWithCondition(tree, aggregateNodes.sumLeafNodes) shouldBe 41
  }

  it should "return the total of even nodes" in {
    aggregateNodes.sumNodesWithCondition(tree, aggregateNodes.sumEvenNodes) shouldBe 44
  }
}
