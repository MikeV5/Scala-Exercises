object AlberiBinariGenerici extends App{

  case class Node[T](value: T, c1: Tree[T], c2: Tree[T]) extends Tree[T]
  case object Empty extends Tree[Nothing]

  trait Tree[+T] {
    override def toString: String = this match {
      case Empty => "."
      case Node(n, c1, c2) => "(" + c1.toString + n + c2.toString + ")"
    }
  }
  def filter_leaves[T](tree: Tree[T],f:T => Boolean): List[T]= {
    tree match {
      case Empty => Nil
      case Node(value, Empty, Empty) =>
        if (f(value))
          List(value)
        else Nil
      case Node(_, t1, t2) =>
        filter_leaves(t1, f) ++ filter_leaves(t2, f)
    }
  }

  def map[T](tree: Tree[T], f: T => T): Tree[T]={
    tree match{
      case Empty => Empty
      case Node(value, Empty, Empty) => tree
      case Node(x,t1,t2)=> Node(f(x),map(t1,f),map(t2,f))
    }
  }

  def size(tree:Tree[Any]):Int={
    val count = 0
    tree match{
      case Empty => count
      case Node(_,t1,t2) => 1 + size(t1)+size(t2)
    }
  }

  val t0 = Node(1, Empty, Empty)
  val t1 = Node(2, Empty, Empty)
  val t3 = Node(4, t0, t1)
  val t4 = Empty
  val t5 = Node(5,t1, t3)
  //println(map(t4, (x:Int)=>x*2))
  //println(t3)
  //println(map(t3, (x:Int)=>x*2))
  //println(size(t3))

  def filter[T](tree: Tree[T], p: T => Boolean):List[T]={
    tree match{
      case Empty => Nil
      case Node(value,t1,t2) =>
        if(p(value))
          List(value) ++ filter(t1,p) ++ filter(t2,p)
        else filter(t1,p) ++ filter(t2,p)
    }
  }
  //println(filter(t4, (x:Int) => true))
  //println(filter(t3, (x:Int) => true))

  def height(tree: Tree[Int]): Int= tree match {
    case Empty => -1
    case Node(_, t1, t2) => Math.max(height(t1), height(t2)) + 1
  }

  def height2(tree: Tree[Int]): Int = {
    def max(a: Int, b: Int): Int =
      if (a >= b) a else b
    tree match {
      case Empty => throw new Error("height.Empty")
      case Node(_, Empty, Empty) => 0
      case Node(n, t1, Empty) => 1 + height(t1)
      case Node(n, Empty, t2) => 1 + height(t2)
      case Node(n, t1, t2) => 1 + max(height(t2), height(t2))
    }
  }

  println(height(t5))
  println(height2(t5))


}
