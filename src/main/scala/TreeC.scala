
sealed trait TreeC[+T]
case object EmptyC extends TreeC[Nothing]
case class NodeC[T](data: Int, left: TreeC[T], right: TreeC[T], children: Int) extends TreeC[T]
