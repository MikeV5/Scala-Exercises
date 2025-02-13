object AlberiDiStringhe extends App{
  abstract class Tree {}
  case class Node(n: String, c1: Tree, c2: Tree) extends Tree
  case object Empty extends Tree

  def occTable(tree: Tree): List[(String, Int)] = tree match {
    case Empty => Nil
    case Node(n, c1, c2) =>
      // Concatena le occorrenze della parola corrente con le occorrenze dei sottoalberi
      (n, 1) :: occTable(c1) ++ occTable(c2)
  }
  val t0 = Node("pippo",Empty,Empty)
  val t1 = Node("topolino",Empty,Empty)
  val t2 = Node("pippo",Empty,Empty)
  val t3 = Node("pluto",t0,t1)
  val t4 = Node("pippo",t2,t3)
  //List((pippo,3), (pluto,1), (topolino,1))

  def occTable2(tree: Tree): List[(String, Int)] = {
    def countOccurrences(t: Tree, acc: Map[String, Int]): Map[String, Int] = t match {
      case Empty => acc
      case Node(n, c1, c2) =>
        // Aggiorna il conteggio delle occorrenze per la parola corrente
        val updatedAcc = acc + (n -> (acc.getOrElse(n, 0) + 1))

        // Chiamate ricorsive sui sottoalberi sinistro e destro
        val leftOccurrences = countOccurrences(c1, updatedAcc)
        val rightOccurrences = countOccurrences(c2, leftOccurrences)

        rightOccurrences
    }

    // Converti la mappa di occorrenze in una lista di coppie (parola, conteggio)
    countOccurrences(tree, Map()).toList
  }
  println(occTable(t4))
  println(occTable2(t4))
}
