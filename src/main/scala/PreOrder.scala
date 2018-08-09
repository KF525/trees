
class PreOrder {
  def traverse(node: Tree[Int], nodes: String = ""): String = node match {
    case Node(d, l, r) =>
      nodes + d + traverse(l) + traverse(r)
    case Empty => nodes
  }
}
