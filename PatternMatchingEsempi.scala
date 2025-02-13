

object PatternMatchingEsempi extends App {

  val mese= 13
  println(mese match {
    case 1 => "Gennaio"
    case 2 => "Febbraio"
    case 6 => "Giugno"
    case _ => "Dicembre"
  })


  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  case class Var(name: String) extends Expr


  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    // ...
  }

println(eval(Sum(Number(3),Number(7))))


}
