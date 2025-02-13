object ListeEsempi extends App{
  def compact[S, T, U](l1: List[S], l2: List[T], f: (S, T) => U): List[U] = {
    if (l1.length != l2.length)
      throw new Exception("Le liste devono avere la stessa lunghezza")
    l1.zip(l2).map { case (elem1, elem2) => f(elem1, elem2) }
  }

  def compact2[S, T, U](l1: List[S], l2: List[T], f: (S, T) => U): List[U] = {
    if (l1.length != l2.length)
      throw new Exception("Le liste devono avere la stessa lunghezza")
    //for(x <-l1; y<-l2) yield f(x, y)
    for (x<-l1;y<-l2) yield f(x, y)
   // for ((x, y) <- l1.zip(l2)) yield f(x, y)
  }

  val lista1 = List(1,2,3,4)
  val lista2 = List(5,6,7,8)
  def  f = (x:Int,y:Int)=>x*y
  val lista3 = compact2(lista1,lista2,f)
  //println( lista1.zip(lista2))

  def  f2 = (x:Int,y:Int)=>x*y
  def prova(lista1: List[Int], lista2:List[Int]): List[Int] = {
    lista1.zip(lista2).map{
      case (elem1, elem2) => f2(elem1, elem2)
    }
  }

  def scaleList(xs: List[Int], factor: Int): List[Int] = {
    xs map (x => x * factor)
  }
  val lista5 = prova(lista1,lista2)
  println(lista5)
}


