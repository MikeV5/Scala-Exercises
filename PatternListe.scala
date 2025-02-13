object PatternListe extends App {

  val lista = List(1,2,3,4,5)
  //println(lista)

  def stampaTestaECoda(lista: List[Int]):Unit={
    lista match {
      case x::xs => println(s"Testa: $x e Coda: $xs")
      case Nil => println(lista.take(3))
    }
  }

  //stampaTestaECoda(lista)

  val myList1 = 1 :: 2 :: 3 ::4::5::6:: Nil
  matchList(myList1)

  val myList2 = 1 :: 5 :: 7 :: Nil
  matchList(myList2)

  def matchList(lst: List[Int]): Unit = lst match {
    case 1 :: 2 :: xs => println(s"La lista inizia con 1 e 2, seguiti da: $xs")
    case _ => println("La lista inizia non inizia con 1 e 2")
  }
}
