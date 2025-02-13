object CorrettezzaEsempi extends App{

  def double(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case head :: tail => head :: head :: head :: head :: double(tail)
  }

  val lista = Vector(2.0,3.0,4.0,5.0)
  val lista2 = Vector(1.0,3.0,5.0,7.0)
  //println(double(lista))

  val listaNumeri= List(1, 2, 3, 4, 5)
  //println(listaNumeri exists (_>5))

  val seq1 = List(1, 2, 3)
  val seq2 = List("one", "two", "three")

  //println(seq1 zip seq2)
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]):  Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  println(scalarProduct(lista, lista2))

}
