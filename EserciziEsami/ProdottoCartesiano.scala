object ProdottoCartesiano extends App{

  def cprod[T,S](l1: List[T], l2: List[S]): List[(T,S)]={
    for{
      x <- l1
      y <-l2
    }yield (x,y)

  }
  val l1 = List(1, 2, 3, 4)
  val l2 = List("uno","due","tre")
  println(cprod(l1,l2))
  println(cprod(l1,Nil))
}
