
class PostOrder {
  def traverse(node: Tree[Int], nodes: String = ""): String = node match {
    case Node(d, l, r) =>
      traverse(l) + traverse(r) + nodes + d
    case Empty => nodes
  }
}
