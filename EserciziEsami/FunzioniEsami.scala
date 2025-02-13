object FunzioniEsami extends App{

  def compact[S,T,U](list1: List[S], list2: List[T],f:(S,T) => U):List[U]={
    if (list1.length != list2.length)
      throw new Exception("Le liste devono avere la stessa lunghezza")
/*
    for{
      (x, y) <- list1 zip list2
    } yield f(x,y)
 */
    (list1 zip list2).map{ case (elem1, elem2)=> f(elem1, elem2) }
  }

  val lista1 = Vector(1, 2, 3)
  val lista2 = Vector(3, 4, 5)
//println(compact(lista1,lista2,(x:Int, y:Int)=>x*y ))


  def scalarProduct(xs: Vector[Int], ys: Vector[Int], f: (Int,Int)=>Int): Vector[Int]= {
    (xs zip ys).map(xy => xy._1 * xy._2)
    //(xs zip ys).map{case (x,y)=>x*y}
    //(xs zip ys).map{case (x,y)=>f(x,y)}

  }
  val prodottoFunzione: (Int, Int) => Int = (x, y) => x * y
  println(scalarProduct(lista1,lista2, prodottoFunzione))
  //println(scalarProduct(lista1,lista2, (x,y)=>x*y))

}
