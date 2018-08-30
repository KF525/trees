class PathSum {
  def hasPathSum(target: Int, tree: Tree[Int]):Boolean =
    tree match {
      case Empty if target == 0 => true
      case Node(d,l,r) => hasPathSum(target - d, l) || hasPathSum(target - d, r)
      case _ => false
    }

  def hasSubPathSum(target: Int, tree: Tree[Int]): Boolean =
    tree match {
      case Empty if target == 0 => true
      case Empty => false
      case Node(d,l,r) if target == 0 => true
      case Node(d, l, r) => hasSubPathSum(target - d, l) || hasSubPathSum(target - d, r) || hasSubPathSum(target, l) || hasSubPathSum(target, r)
    }
}