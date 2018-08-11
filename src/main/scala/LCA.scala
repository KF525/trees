
class LCA {
  def findLowestCommonAncestorInBST(node: Tree[Int], data1: Int, data2: Int): Tree[Int] =
    node match {
      case Node(d, _, r) if d < data1 && d < data2 => findLowestCommonAncestorInBST(r, data1, data2)
      case Node(d, l, _) if d > data1 && d > data2 => findLowestCommonAncestorInBST(l, data1, data2)
      case Node(_, _, _) => node
      case _ => Empty
    }

  def findLowestCommonAncestorInBSTAndConfirmNodePresence(node: Tree[Int], data1: Int, data2: Int): Tree[Int] = {
    val parents1 = findParents(node, data1)
    val parents2 = findParents(node, data2)
    compareParents(parents1, parents2)
  }

  private def findParents(node: Tree[Int], data: Int, parents: List[Tree[Int]] = List()): List[Tree[Int]] =
    node match {
      case Node(d, _, r) if d < data => findParents(r, data, parents :+ node)
      case Node(d, l, _) if d > data => findParents(l, data, parents :+ node)
      case Node(d, _, _) if d == data => parents :+ node
      case Empty => List()
    }

  private def compareParents(parents1: List[Tree[Int]], parents2: List[Tree[Int]]): Tree[Int] =
    (parents1, parents2) match {
      case (Node(d1,_,_)::Node(d2,l2,r2)::x1, Node(d3,_,_)::Node(d4,l4,r4)::x2) if (d1 == d3) && (d2 == d4) =>
        compareParents(Node(d2,l2,r2)::x1, Node(d4,l4,r4)::x2)
      case (Node(d1,l,r)::Node(d2,_,_)::x1, Node(d3,_,_)::Node(d4,_,_)::x2) if (d1 == d3) && (d2 != d4) => Node(d1,l,r)
      case (Node(d1,l,r)::Node(d2,_,_)::x1, Node(d3,_,_)::Nil) if d1 == d3 => Node(d1,l,r)
      case (Node(d1,l,r)::Nil, Node(d3,_,_)::Node(d4,_,_)::x2) if d1 == d3 => Node(d1,l,r)
      case _ => Empty

    }
}