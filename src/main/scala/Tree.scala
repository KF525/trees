
sealed trait Tree[+T]
case object Empty extends Tree[Nothing]
case class Node[T](data: T, left: Tree[T], right: Tree[T]) extends Tree[T]


