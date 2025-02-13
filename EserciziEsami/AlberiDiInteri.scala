object AlberiDiInteri extends App {

  abstract class Tree {}

  case class Node(n: Int, c1: Tree, c2: Tree) extends Tree

  case object Empty extends Tree

  def findMax(tree: Tree): Int = tree match {
    case Empty => throw new Error("findMax.Empty")
    case Node(n, Empty, Empty) => n
    case Node(n, t1, Empty) =>
      val maxt1 = findMax(t1)
      if (n >= maxt1) n else maxt1
    case Node(n, Empty, t2) =>
      val maxt2 = findMax(t2)
      if (n >= maxt2) n else maxt2
    case Node(n, t1, t2) =>
      val maxt1 = findMax(t1)
      val maxt2 = findMax(t2)
      if (n >= maxt1 && n >= maxt2)
        n
      else if (maxt1 >= maxt2)
        maxt1
      else maxt2
  }

  def leaves(tree: Tree): List[Int] = tree match {
    case Empty => throw new Error("leaves.Empty")
    case Node(n, Empty, Empty) => List(n)
    case Node(n, t1, Empty) => leaves(t1)
    case Node(n, Empty, t2) => leaves(t2)
    case Node(n, t1, t2) => leaves(t1) ++ leaves(t2)
  }

  def listaFoglie(bts: Tree): List[Int] = bts match {
    case Empty => Nil
    case Node(v, Empty, Empty) => List(v)
    case Node(value, left, right) => listaFoglie(left) ++ listaFoglie(right)
  }

  val t0 = Node(5, Empty, Empty)
  val t1 = Node(-3, Empty, Empty)
  val t2 = Node(4, Empty, Empty)
  val t3 = Node(-7, t0, t1)
  val t4 = Node(7, t2, t3)

  val t = Node(10, Node(5, Empty, Empty), Node(15, Empty, Empty))
  //println(findMax(t))  // Output: 15
  //println(leaves(t4))
  //println(listaFoglie(t4))

  def globalPack1[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil => List()
    case x :: xs1 => val (testa, coda) = xs partition (y => y == x)
      (testa.head, testa.length) :: globalPack1(xs1 filter (y => y != x))
  }

  val xs = 'a' :: 'b' :: 'a' :: 'd' :: 'a' :: 'd' :: Nil
  //println(globalPack1(xs))

  def primePairs(n: Int, m: Int): List[(Int, Int)] = {
    def isPrime(n: Int): Boolean =
      (2 until n) forall (x => n % x != 0)

    val allPairs = (1 to n) flatMap (x => (1 to m) map (y => (x, y)))
    allPairs.filter(x => isPrime(x._1 + x._2)).toList
  }


  def primePairs2(n: Int, m: Int): List[(Int, Int)] = {

    def isPrime(n: Int): Boolean = (2 until n) forall (x => n % x != 0)

    val pairs = for {
      i <- 1 to n
      j <- 1 to m
      if isPrime(i + j)
    } yield (i, j)
    pairs.toList
  }

  //println(primePairs(5,5))
  //println(primePairs2(5,5))
  def nDiv(n: Int): Int = {
    def iter(count: Int, nDiv: Int): Int = {
      if (count == 1) nDiv
      else if (n % count == 0) iter(count - 1, nDiv + 1) else iter(count - 1, nDiv)
    }

    if (n <= 2) return 0
    else iter(n / 2, 0)
  }

  def nDiv2(n: Int): Int = {
    if (n < 0) // Gestiamo il caso in cui n è minore di 0
      throw new Error("Il numero deve essere >= 0.")
    else {
      val divisors = (2 until n).filter(y => n % y == 0)
      divisors.length
    }
  }

  //println(nDiv(-20))
  //println(nDiv2(-3))

  def cprod[T, S](l1: List[T], l2: List[S]): List[(T, S)] ={
  for {
    x <- l1
    y <- l2
  } yield (x, y)
}

  val lista1 = List(1, 2, 3)
  val lista2 = List(3, 4, 5)


  def coppie(x: Int, y: Int): List[(Int, Int)] = {
    if (x <= 0 || y <= 0) {  // Verifica che x e y siano strettamente positivi
      throw new Error("Entrambi i numeri devono essere strettamente positivi.")
    }
    val listaCoppie = for {   // Genera la lista di tutte le coppie (i, j)
      i <- 1 to x
      j <- 1 to y
    } yield (i, j)
    listaCoppie.toList  // for expression genera una sequenza
    //quindi dobbiamo convertirla ad una lista
  }

  def globalPack3[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil => List() // Caso base: la lista è vuota, restituisci una lista vuota
    case x :: xs1 =>
      val (testa, coda) = xs.partition(y => y == x) // Partiziona la lista in elementi uguali e il resto
      (x, testa.length) :: globalPack3(coda) // Aggiungi la coppia (elemento, numero di occorrenze) alla lista risultante
  }
  val xs2 = 'a':: 'b':: 'a':: 'd':: 'a':: 'd':: Nil
  //println(globalPack3(xs2))

  val lista3 = List(1, 2, 3, 4, 5)
  val lista4 = List(3, 5)
  def diff[T](xs: List[T], ys: List[T]): List[T] = {
    xs.filterNot(ys.contains)
  }

  def diff2[T](xs: List[T], ys: List[T]): List[T] = {
    xs.filter(x => !ys.contains(x))
  }
  println(diff2(lista3, lista4))

}
