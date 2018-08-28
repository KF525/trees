

class LevelCount {

  def countNodes(desiredLevel: Int, tree: Tree[Int]): Int =
    if (desiredLevel < 0) 0 else countHelper(desiredLevel, tree, 0)

  def countHelper(desiredLevel: Int, tree: Tree[Int], currentLevel: Int):Int =
    tree match {
      case Empty => 0
      case Node(_, l, r) =>
        if (currentLevel.equals(desiredLevel)) 1 else
          countHelper(desiredLevel, l, currentLevel + 1) + countHelper(desiredLevel, r, currentLevel + 1)
    }
}
