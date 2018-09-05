class BSTCheck {

  def isBST(tree: Tree[Int]): Boolean =
    tree match {
      case Empty => true
      case Node(d, l, r) => if (compareNodes(d, l, r)) isBST(l) && isBST(r) else false
    }

  private def compareNodes(data: Int, left: Tree[Int], right: Tree[Int]) =
    (left, right) match {
      case (Empty, Empty) => true
      case (Node(dl, ll, rl), Node(dr, lr, rr)) => (data > dl) && (data < dr)
      case (Node(dl, ll, rl), _) => data > dl
      case (_, Node(dr, lr, rr)) => data < dr
    }
}
