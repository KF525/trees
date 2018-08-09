
class LCA {
  def findLowestCommonAncestorInBST(node: Tree[Int], data1: Int, data2: Int): Tree[Int] = node match {
      case Node(d, _, r) if d < data1 && d < data2 => findLowestCommonAncestorInBST(r, data1, data2)
      case Node(d, l, _) if d > data1 && d > data2 => findLowestCommonAncestorInBST(l, data1, data2)
      case Node(_, _, _) => node
      case _ => Empty
    }

  def findLowestCommonAncestorInBSTAndConfirmNodePresence(node: Tree[Int], data1: Int, data2: Int,
                                                          currentParents: List[Tree[Int]]): Tree[Int] = ???


}