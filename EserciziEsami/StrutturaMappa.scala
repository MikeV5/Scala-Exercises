object StrutturaMappa extends App{
/*
  trait Expr
  case class Num(n: Int) extends Expr
  case class Sum(e1: Expr, e2:Expr) extends Expr
  case class Prod(e1: Expr, e2:Expr) extends Expr
  case class Var(name: String) extends Expr


  def exprSub(expr: Expr, sub: Map[Var, Expr]): Expr = expr match {
    case Var(x) => if (sub contains Var(x)) sub(Var(x))
    else throw new Error("Valore non definito per " + x)
    case Num(n) => Num(n)
    case Sum(e1, e2) => Sum(exprSub(e1, sub), exprSub(e2, sub))
    case Prod(e1, e2) => Prod(exprSub(e1, sub), exprSub(e2, sub))
  }

  val expr = Sum(Var("x"), Num(5))
  val s = Map(Var("x") -> Sum(Num(1),Num(2)), Var("y") -> Prod(Num(3),Num(4)))
  println(exprSub(expr, s))
*/
/*
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2:Expr) extends Expr
  case class Prod(e1: Expr, e2:Expr) extends Expr
  case class Var(name: String) extends Expr

  def eval(expr: Expr, sub: Map[String, Int]): Int = expr match {
    case Var(x) => if (sub contains x) sub(x)
    else throw new Error("Valore non definito per " + x)
    case Number(n) => n
    case Sum(e1, e2) => eval(e1, sub) + eval(e2, sub)
    case Prod(e1, e2) => eval(e1, sub) * eval(e2, sub)
  }

  val expr = Var("x")
  val s = Map("x" -> 3, "y" -> 5, "z" -> 2)
  println(eval(Var("z"), s))
*/
  /*
trait Tree[+T] {
  override def toString: String = this match {
    case Empty => "."
    case Node(n, c1, c2) => "(" + c1.toString + n + c2.toString + ")"
  }
}
  case class Node[T](value: T, c1: Tree[T], c2: Tree[T]) extends Tree[T]
  case object Empty extends Tree[Nothing]

  def filter[T](tree: Tree[T], p: T => Boolean) : List[T] = tree match {
    case Empty => Nil
    case Node(x, t1, t2) =>
      if (p(x))
        List(x) ++ filter(t1, p) ++ filter(t2, p)
  else
  filter(t1, p) ++ filter(t2, p)
  }
  def filter2[T](tree: Tree[T], p: T => Boolean) : List[T] = tree match {
    case Empty => Nil
    case Node(x, Empty, Empty) => if (p(x)) List(x) else Nil
    case Node(_, t1, t2) =>   filter2(t1, p) ++ filter2(t2, p)
  }

  val t0 = Node(1, Empty, Empty)
  val t1 = Node(2, Empty, Empty)
  val t3 = Node(4, t0, t1)
  println(filter(t3,(x:Int) => true))
  println(filter2(t3,(x:Int) => true))
*/
/*
  sealed trait Wff {}
  case class Atom(name: String) extends Wff
  case class And(left: Wff, right: Wff) extends Wff
  case class Or(left: Wff, right: Wff) extends Wff
  case class Not(subf: Wff) extends Wff
  case class Implies(a: Wff, c: Wff) extends Wff

  def countAtomOccurrences(wff: Wff, list: List[Atom]) : List[(Atom,Int)] ={
    // build the list of atoms in wff
    def atomList(wff: Wff): List[Atom] = wff match {
      case Atom(p) => if (list contains wff) List(Atom(p)) else Nil
      case Not(sub) => atomList(sub)
      case And(left, right) => atomList(left) ++ atomList(right)
      case Or(left, right) => atomList(left) ++ atomList(right)
      case Implies(left, right) => atomList(left) ++ atomList(right)
    }
    // extract the pairs (x,n) counting the number n of occurrences of x in list
    def iter(list: List[Atom], res: List[(Atom,Int)]) : List[(Atom,Int)] = list match {
      case Nil => res
      case head::tail => {
        val (a,b) = list partition (x=> x == head)
        iter(b, (head,a.length) :: res)
      }
    }
    iter(atomList(wff),Nil)
  }
  val p = Atom("p")
  val q = Atom("q")
  val r = Atom("r")
  val w0 = And(p,q)
  val w1 = And(p,r)

  println(countAtomOccurrences(w1, List(Atom("p"),Atom("r"))))
*/
/*
  sealed trait Wff {}
  case class Atom(name: String) extends Wff
  case class And(left: Wff, right: Wff) extends Wff
  case class Or(left: Wff, right: Wff) extends Wff
  case class Not(subf: Wff) extends Wff
  case class Implies(a: Wff, c: Wff) extends Wff

  def atomToDoubleNeg(wff: Wff, list : List[Atom]) : Wff = wff match {
    case Atom(_) => if (list contains wff)
                   Not(Not(wff))
                     else wff
    case And(left,right) =>
      And(atomToDoubleNeg(left, list), atomToDoubleNeg(right, list))
    case Or(left,right) =>
      Or(atomToDoubleNeg(left,list),atomToDoubleNeg(right,list))
    case Implies(left,right) =>
      Implies(atomToDoubleNeg(left, list), atomToDoubleNeg(right, list))
    case Not(s) => Not(atomToDoubleNeg(s, list))
  }

  val p = Atom("p")
  val q = Atom("q")
  val r = Atom("r")
  val w0 = And(p,q)
  val w1 = And(q,r)

  println(atomToDoubleNeg(w1, List(Atom("p"),Atom("r"))))*/

  trait Tree[+T] {
    override def toString: String = this match {
      case Empty => "."
      case Node(n, c1, c2) => "(" + c1.toString + n + c2.toString + ")"
    }
  }
  case class Node[T](value: T, c1: Tree[T], c2: Tree[T]) extends Tree[T]
  case object Empty extends Tree[Nothing]

  def map[T](tree: Tree[T], f: T => T) : Tree[T] = tree match {
    case Empty => Empty
    case Node(x, Empty, Empty) => Node(x, Empty, Empty)
    case Node(x, t1, t2) =>
      Node(f(x), map(t1, f), map(t2, f))
  }

  val t0 = Node(1, Empty, Empty)
  val t1 = Node(2, Empty, Empty)
  val t3 = Node(4, t0, t1)
 // println(map(t1,(x:Int) => 2*x))

  def estraiCifre(n:Int):List[Int]={
    def extr(n:Int):List[Int]={
      if(n/10==0)
        List(n)
      else extr(n/10)++List(n%10)
    }
    val absN = n.abs
    extr(absN)
  }
 // println(estraiCifre(5))

  sealed trait Wff {}
  case class Atom(name: String) extends Wff
  case class And(left: Wff, right: Wff) extends Wff
  case class Or(left: Wff, right: Wff) extends Wff
  case class Not(subf: Wff) extends Wff
  case class Implies(a: Wff, c: Wff) extends Wff

  def countAtomOccurrences(wff: Wff, list: List[Atom]) : List[(Atom,Int)] ={
    // build the list of atoms in wff
    def atomList(wff: Wff): List[Atom] = wff match {
      case Atom(p) => if (list contains wff) List(Atom(p)) else Nil
      case And(left, right) => atomList(left) ++ atomList(right)
      case Or(left, right) => atomList(left) ++ atomList(right)
      case Not(sub) => atomList(sub)
      case Implies(left, right) => atomList(left) ++ atomList(right)
    }
    // extract the pairs (x,n) counting the number n of occurrences of x in list
    def iter(list: List[Atom], res: List[(Atom, Int)]) : List[(Atom, Int)] = list match {
      case Nil => res
      case head::tail => {
        val (a, b) = list partition (x=> x == head)
        iter(b, (head, a.length) :: res)
      }
    }
    iter(atomList(wff), Nil)
  }


}
