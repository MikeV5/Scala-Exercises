object NumeroDivisori extends App{

  def countDivisors(n: Int): Int = {
    // Inizializziamo il conteggio dei divisori
    var count = 0

    // Iteriamo da 2 a n-1 per verificare i divisori
    for (i <- 2 until n) {
      if (n % i == 0) {
        // Se i è un divisore di n, incrementiamo il conteggio
        count += 1
      }
    }

    // Restituiamo il numero totale di divisori propri
    count
  }

  def nDiv(n: Int)= {
    // Gestiamo il caso in cui n è minore di 0
    if (n < 0) {
      throw new Error("Il numero deve essere >= 0.")
    } else {
      // Inizializziamo il conteggio dei divisori
      var count = 0
      // Iteriamo da 2 a n-1 per verificare i divisori
      for (i <- 2 until n) {
        if (n % i == 0) {
          // Se i è un divisore di n, incrementiamo il conteggio
          count += 1
        }
      }
      // Restituiamo il numero totale di divisori propri
      count
    }
  }

  def listDiv(n: Int): List[Int] = {
    // Gestiamo il caso in cui n sia minore o uguale a 0
    //def absolute(n: Int): Int = if (n >= 0) n else -n
    val absoluteN = n.abs
      // Filtriamo i divisori positivi di n in ordine decrescente
      (1 until absoluteN).filter(i => (absoluteN % i == 0) ).reverse.toList
  }
  //println(listDiv(-10))
  //println(countDivisors(-1))
  //println(nDiv(-1))

  def coppie(x: Int, y: Int): List[(Int, Int)] = {
    // Verifica che x e y siano strettamente positivi
    if (x <= 0 || y <= 0) {
      throw new Error("Entrambi i numeri devono essere strettamente positivi.")
    }

    // Genera la lista di tutte le coppie (i, j)
    val listaCoppie = for {
      i <- 1 to x
      j <- 1 to y
    } yield (i, j)

    // Converte la sequenza in una lista
    listaCoppie.reverse.toList
  }
  println(coppie(2,3))
}
