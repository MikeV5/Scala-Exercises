object Kata extends App{
  def smallEnough(n: Seq[Int], l: Int): Boolean = {
    val nuovaLista = n filter (_ > l) // invece di (x => x > 0)
    nuovaLista.length == 0
  }

  def smallEnough2(n: Seq[Int], l: Int): Boolean = n forall (_<=l)


  val listaNum = List(1, 2, 4, 5, 6)
  //println(smallEnough(listaNum, 7))
  //println(smallEnough2(listaNum, 7))

  val listaOggetti = List(1,2,"ab",3,"de")
  def filterList(list: List[Any]): List[Int] = {
    list.collect  {
      case x: Int => x
    }
  }
  //println(filterList(listaOggetti))

  def filterList2(list: List[Any]): List[Any] =
    list.filter(x=>x.isInstanceOf[Int]).map(x => x.asInstanceOf[String])

 //println(filterList2(listaOggetti))
  //println( listaOggetti.filter(a => a.isInstanceOf[Int]))



}

