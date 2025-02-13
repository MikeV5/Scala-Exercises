object FormuleProp extends App{
  /*
  sealed trait Wff {}
  case class True() extends Wff
  case class False() extends Wff
  case class Atom(name: String) extends Wff
  case class And(left: Wff, right: Wff) extends Wff
  case class Not(subf: Wff) extends Wff


  def countAndOfAtoms(wff: Wff) : Int = wff match {
    case And(Atom(_),Atom(_)) => 1
    case True() | False() | Atom(_) => 0
    case And(left, right) => countAndOfAtoms(left) + countAndOfAtoms(right)
    case Not(sub) => countAndOfAtoms(sub)
  }
  val p = Atom("p")
  val q = Atom("q")
  val r = Atom("q")
  val w0 = And(p,q)
  val w1 = And(p,r)
  val w2 = And(w0, w1)
  println(countAndOfAtoms(w2)) //¬¬p --> p = Atom(p)
*/
  /*
  sealed trait Wff {}
  case class True() extends Wff
  case class False() extends Wff
  case class Atom(name: String) extends Wff
  case class And(left: Wff, right: Wff) extends Wff
  case class Or(left: Wff, right: Wff) extends Wff
  case class Not(subf: Wff) extends Wff
  case class Implies(a: Wff, c: Wff) extends Wff

  def occurr(a : Atom, wff: Wff): Boolean = wff match {
    case True() | False() => false
    case Atom(p) => p == a.name
    case And(l, r) => occurr(a, l) || occurr(a, r)
    case Or(l, r) => occurr(a, l) || occurr(a, r)
    case Not(s) => occurr(a, s)
    case Implies(p, c) => occurr(a, p) || occurr(a, c)
  }

  def elimImplies(wff: Wff) : Wff = wff match {
    case And(l, r) => And(elimImplies(l), elimImplies(r))
    case Or(l, r) => Or(elimImplies(l), elimImplies(r))
    case Not(s) => Not(elimImplies(s))
    case Implies(p, c) => Or(Not(elimImplies(p)), elimImplies(c))
    case _ => wff
  }
  val p = Atom("p")
  val q = Atom("q")
  val r = Atom("r")
  val w0 = And(p,q)
  val w1 = And(p,r)
  val w2 = And(w0, w1)
  val w3 = False()
  val w4 = Implies(p,q)
  //println(elimImplies(w4))
  //println(occurr(r,w1)) //¬¬p --> p = Atom(p)

  trait Expr
  case class Num(n: Int) extends Expr
  case class Sum(e1: Expr, e2:Expr) extends Expr
  case class Prod(e1: Expr, e2:Expr) extends Expr
  case class Var(name: String) extends Expr

  def countOp(expr:Expr): List[(String, Int)] = {
    def linearize(expr: Expr): List[String] = {
      expr match {
        case Sum(e1, e2) => List("Sum") ++ linearize(e1) ++ linearize((e2))
        case Prod(e1, e2) => List("Prod") ++ linearize(e1) ++ linearize(e2)
        case Var(_) => List("Var")
        case Num(_) => List("Num")
      }
    }
    // Lista degli operatori da contare
    def elements = List("Sum", "Prod", "Num", "Var")
    // Linearizza l'espressione di input
    def linearized = linearize(expr)
    for {
      e <- elements
      n = (linearized filter (x => x == e)).length
    } yield (e, n) // Restituisce una coppia (operatore, numero di occorrenze)
  }

  //println(countOp(Num(10)))

  def globalPack[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil => List()
    case x :: ys =>
    val (testa, coda) = xs.partition(y => y == x)
    (x, testa.length) :: globalPack(coda)
  }

  val lista = 'a'::'b'::'a'::'a'::Nil
  println(globalPack(lista))
*/

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

  //println(elimImplies(w4))
  //println(occurr(r,w1)) //¬¬p --> p = Atom(p)

}

