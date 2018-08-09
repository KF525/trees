
class InOrder {
  def traverse(node: Tree[Int], nodes: String = ""): String = node match {
    case Node(d, l, r) =>
      traverse(l) + nodes + d + traverse(r)
    case Empty => nodes
  }
}
