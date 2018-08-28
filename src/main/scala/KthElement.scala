
class KthElement {

  def kthSmallestElement(tree: TreeC[Int], kElement: Int): TreeC[Int] =
    //if k < 0 or k > tree.size then we know it's invalid
    tree match {
      case NodeC(_, l, _, _) if onNode(kElement, l) => tree
      case NodeC(_, l, _, c) if findNextSubtree(l, kElement, lessThan(kElement)) => kthSmallestElement(l, kElement)
      case NodeC(_, l, r, c) if findNextSubtree(l, kElement, greaterThan(kElement)) =>
        val countedNodes = nodesToRemoveFromK(l)
        kthSmallestElement(r, kElement - countedNodes)
      case _ => EmptyC
  }

  def greaterThan(a: Int) = (b: Int) => a > b

  def lessThan(a: Int) = (b: Int) => a <= b

  def onNode(k: Int, l: TreeC[Int]): Boolean = l match {
    case NodeC(_,_,_,c) if c + 1 == k => true
    case EmptyC if 1 == k => true
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

// If runtime not an issue or tree is very small, in order traversal into an array and select k-1 element from array