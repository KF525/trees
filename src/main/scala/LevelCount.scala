

class LevelCount {

  def countNodes(desiredLevel: Int, tree: Tree[Int]): Int =
    if (desiredLevel < 0) 0 else countHelper(desiredLevel, tree)

  def countHelper(desiredLevel: Int, tree: Tree[Int]):Int =
    tree match {
      case Empty => 0
      case Node(_, l, r) =>
        if (desiredLevel.equals(0)) 1 else
          countHelper(desiredLevel - 1, l) + countHelper(desiredLevel - 1, r)
    }
}
