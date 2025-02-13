object Esempi extends App{

  val lista1 = Vector(2.0, 3.0, 4.0, 5.0)
  val lista2 = Vector(1.0, 3.0, 5.0, 7.0)


  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map({case (x, y) => x * y}).sum

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Vector[Double] =
      (xs zip ys).map(z => z._1 * z._2)


  //println(scalarProduct(lista1,lista2))

  def scalarProduct3(xs: Vector[Double], ys: Vector[Double]):Vector[Double] =
    (for ((x, y) <- xs zip ys) yield x * y)
  //println(scalarProduct3(lista1,lista2))


  val numbers = List(1, 2, 3, 4, 5)

  val squaredNumbers = for {
    x <- numbers
     quadrato = x*x
  } yield quadrato

  //println(numbers map(x=>x*x))

  println(squaredNumbers)
  // squaredNumbers sarà List(1, 4, 9, 16, 25)
  val parole = List("ananas","mela","uva","mandarino")
  val paroleConM = for {
    x <- parole
    if !x.startsWith("m")
  } yield x

  //println(paroleConM)
  //println(parole filter(_.startsWith("m")))

}

