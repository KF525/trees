class BalancedTree {



  def isBalanced(tree: Tree[Int]): Boolean =
    tree match {
      case Empty => true //decide what you want to do with an empty input
      case _ =>
        val min = balanceHelper(tree, minDepth)
        val max = balanceHelper(tree, maxDepth)
        max - min < 2
    }

  private def balanceHelper(tree: Tree[Int], f: (Int, Int) => Int, depth: Int = 0): Int =
    tree match {
      case Empty => depth
      case Node(_, l,r) =>
        f(balanceHelper(l, f, depth + 1), balanceHelper(r, f, depth+1))
    }

  private def minDepth: (Int, Int) => Int = (a: Int, b: Int) => a.min(b)
  private def maxDepth: (Int, Int) => Int = (a: Int, b: Int) => a.max(b)
  //get the min and mex depth of the tree and compare
}
