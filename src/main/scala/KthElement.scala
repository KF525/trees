
class KthElement {

  def kthSmallestElement(tree: TreeC[Int], kElement: Int): TreeC[Int] =
    (kElement,tree) match {
      case (1, NodeC(_, EmptyC, _, _)) => tree
      case (1, NodeC(_, l, _, _)) => kthSmallestElement(l, kElement)
      case (_,_) => kthSmallestElementH(tree, kElement)
    }

  def kthSmallestElementH(tree: TreeC[Int], kElement: Int): TreeC[Int] = (kElement, tree) match {
    case (n, NodeC(_, l, _, _)) if checkCurrentNode(n, l) => tree
    case (1, NodeC(_, EmptyC, _, _)) => tree
    case (1, NodeC(_, l, _, _)) => l
    case (n, NodeC(_, l, _, c)) if findNextSubtree(l, n, lessThan(n)) => kthSmallestElementH(l, n)
    case (n, NodeC(_, l, r, c)) if findNextSubtree(l, n, greaterThan(n)) =>
      val countedNodes = nodesToRemoveFromK(l)
      kthSmallestElementH(r, n - countedNodes)
    case (_, _) => EmptyC
  }

  def greaterThan(a: Int) = (b: Int) => a > b

  def lessThan(a: Int) = (b: Int) => a <= b

  def checkCurrentNode(k: Int, l: TreeC[Int]): Boolean = l match {
    case NodeC(_,_,_,c) if c + 1 == k => true
    case _ => false
  }

  def findNextSubtree(t: TreeC[Int], k: Int, f: (Int) => Boolean): Boolean =
    t match {
      case EmptyC => false
      case NodeC(_, _, _, c) if f(c)  => true
      case _ => false
    }

  def nodesToRemoveFromK(l: TreeC[Int]): Int = l match {
    case NodeC(_,_, _, c) => c + 1
    case EmptyC => 1
  }
}

// If runtime not an issue, in order traversal into an array and select k-1 element from array
