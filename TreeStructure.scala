object TreeStructure extends App {
  sealed trait BTree[+T]
  case class BTNode[T](n: T, left: BTree[T], right: BTree[T]) extends BTree[T] {
    override def toString: String = "(" + left.toString + n + right.toString + ")"
  }

  case object BTEmpty extends BTree[Nothing] {
    override def toString: String = "."
  }

  // Albero di esempio
  val t2 = BTNode(3, BTEmpty, BTEmpty)
  println(t2) // Visualizza l'albero creato

  val t3 = BTNode(5, BTNode(3, BTEmpty, BTEmpty), BTEmpty)
  println(t3) // Visualizza un'albero più complesso
}
