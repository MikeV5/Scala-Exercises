object SommaLista  extends App{

  def sommaPos(lista1: List[Int]): Int={
    if(lista1.isEmpty) return 0
    (lista1 filter(_ > 0)).sum
  }

  val ls = List(1, -1, 2, -2, 3, -3, 4, -4, 5, -5)
  //println(sommaPos(ls))
  val ls2 = List()
  //println(sommaPos(ls2))

  val min = 1
  val max = 10
  val step = 2

  def sumCond(min: Int, max: Int, step:Int, p: Int => Boolean) : Int = {
    ((min to max).by(step) filter (x => p(x))).sum

  }
  println(  sumCond(1,6,3, x => (x%2 == 0)))
}
