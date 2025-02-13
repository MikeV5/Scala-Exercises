object SommaRircorsione extends App{
  def somma(n: Int): Int = {
    if (n <= 0) 0
    else n + somma(n - 1)
  }

  def sommaTailRec(n: Int): Int = {
    def sommaHelper(acc: Int, x: Int): Int = {
      if (x <= 0) acc
      else sommaHelper(acc + x, x - 1)    //
      // sommaHelper(0,4) acc=0
      // (4, 3) acc = 4
      // (7, 2) acc= 7
      // (9, 1) acc = 0
      // (10, 0) acc= 10
      // siccome x <= 0 restituisce acc = 10
    }
    sommaHelper(0, n)
  }

  println(sommaTailRec(4))
}
