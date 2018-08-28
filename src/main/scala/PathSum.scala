class PathSum {
  def hasPathSum(target: Int, tree: Tree[Int]):Boolean =
    sumPathHelper(target, tree, 0)

  def sumPathHelper(target: Int, tree: Tree[Int], total: Int): Boolean = {
    tree match {
      case Empty if target == total => true
      case Node(d, l, r) if total + d <= target =>
        sumPathHelper(target, l, total + d) || sumPathHelper(target, r, total + d)
      case _ => false
    }
  }
}
