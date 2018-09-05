class UpdateTree {
  def addNode(data: Int, tree: Tree[Int]): Tree[Int] =
    tree match {
      case Empty =>
        Node(data, Empty, Empty)
      case Node(d, l,r) =>
        if (d > data) Node(d, addNode(data, l), r)
        else Node(d, l, addNode(data, r))
    }

}
