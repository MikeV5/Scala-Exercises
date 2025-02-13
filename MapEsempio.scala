object MapEsempio extends App{

  val lista = List(1,2,-3,4,8,5,6,-8)
  def scaleList(xs: List[Int], factor: Int):List[Int]={
    xs match{
      case Nil => Nil
      case y::ys => (y * factor) :: (scaleList(ys,factor))
    }
  }
  val lista2 = scaleList(lista,5)
  //println(lista2)

  def scaleList2(xs: List[Int], factor: Int):List[Int]={
      xs map (x => x * factor)
  }



  //println(scaleList2(lista,7))



  def positiviElementi(xs: List[Int]):List[Int]={
    xs match{
      case Nil => Nil
      case y :: ys => if(y < 0) y :: positiviElementi(ys) else positiviElementi(ys)
    }
  }
  //println(positiviElementi(lista))
  //println(lista.reduce((x,y)=> x max y))
  val listaNumeri = List(1, 2, 3, 4, 5)

  // Esempio con foldLeft
  val prodottoFoldLeft = listaNumeri.foldLeft(0)((acc, x) => acc + x)
  println(s"Prodotto con foldLeft: $prodottoFoldLeft") // Output: 120 (1 * 2 * 3 * 4)

}
