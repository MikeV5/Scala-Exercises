object FormuleProposizionali extends App{
  sealed trait Wff {}
  case class Atom(name: String) extends Wff
  case class And(left: Wff, right: Wff) extends Wff
  case class Or(left: Wff, right: Wff) extends Wff
  case class Not(subf: Wff) extends Wff
  case class Implies(a: Wff, c: Wff) extends Wff

  def elimDoubleNeg(wff: Wff) : Wff = wff match {
    case Atom(_) => wff
    case And(left, right) => And(elimDoubleNeg(left), elimDoubleNeg(right))
    case Or(left, right) => Or(elimDoubleNeg(left), elimDoubleNeg(right))
    case Implies(left, right) => Implies(elimDoubleNeg(left), elimDoubleNeg(right))
    case Not(Not(s)) => elimDoubleNeg(s)
    case Not(s) => Not(elimDoubleNeg(s))
  }
  println(elimDoubleNeg(Not(Not(Not(Atom("p")))))) //¬¬p --> p = Atom(p)
  println(elimDoubleNeg(Not(Not(Not(Atom("p")))))) //¬¬¬p --> ¬p = Not(Atom(p))

}
