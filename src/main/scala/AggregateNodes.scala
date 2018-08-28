import scala.annotation.tailrec

class AggregateNodes {
  def sumNodes(node: Tree[Int]): Int = node match {
    case Empty => 0
    case Node(d, l, r) => d + sumNodes(l) + sumNodes(r)
  }

  def sumNodesWithCondition(node: Tree[Int], f: Tree[Int] => Int): Int =
    node match {
      case Empty => 0
      case Node(d, l, r) => f(node) + sumNodesWithCondition(l, f) + sumNodesWithCondition(r, f)
    }

  def sumLeafNodes: Tree[Int] => Int = { // equivalent to: (node: Tree[Int]) => node match {
    case Node(d, Empty, Empty) => d
    case _ => 0
  }

  def sumEvenNodes: Tree[Int] => Int = {
    case Node(d, _, _) if d % 2 == 0 => d
    case _ => 0
  }

  def countNodes(node: Tree[Int]): Int = node match {
    case Empty => 0
    case Node(_, l, r) => 1 + countNodes(l) + countNodes(r)
  }

  def returnNodeAverage(node: Tree[Int]): Int = {
    val average = averageHelper(node)
    average.sum / average.count
  }

  private def averageHelper(node: Tree[Int]): Average = node match {
    case Empty => Average(0, 0)
    case Node(d, l, r) => Average(d, 1).combine(averageHelper(l)).combine(averageHelper(r))
  }

  def tailRecSumNodes(node: Tree[Int]) = {
    @tailrec
    def helper(tree: List[Tree[Int]], acc: Int): Int = tree match {
      case Nil => acc
      case Node(d, l, r)::xs => helper(l::r::xs, acc + d)
      case Empty::xs => helper(xs, acc)
    }
    helper(List(node), 0)
  }
}
