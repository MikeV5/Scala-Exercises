object Basics extends App{
  val parola: String = "ciao"
  val pi: Double = 3.1416

  def somma(x: Int, y: Int):Int = x+y
  def concatena(x: String, y: String): String =
    x + y
  //print(concatena("ciao","mondo"))

  def numPariFinoA(n: Int): List[Int] = {

    var listaNumeriPari = List[Int]()
    for(i<- 1 until n){
      if(i%2==0){
        listaNumeriPari = listaNumeriPari :+ i
      }
    }
  listaNumeriPari
  }
  //print(numPariFinoA(99))
  /*
val n: Int = 5
  for(i<-1 to n){
    print(i)
  }*/

  val listaNumeri= List(1,2,3,4,5,6)
  def reduce(x: List[Int]):Int ={
    var sommaTotale: Int = 0
    for(i<-0 until x.length){ //da 0 a 3 perché con until --> x.length-1 --> 4-1 = 3
      sommaTotale = sommaTotale + x(i)
    }
    sommaTotale
  }
  //print(reduce(listaNumeri)) //stampa: 10


  def numPariLista(x: List[Int]): List[Int]={
    var listaNum = List[Int]()

    for(i<-0 until x.length){
      if(x(i)%2==0){
        listaNum = listaNum :+ x(i)
      }
    }
    listaNum
  }
//println(numPariLista(listaNumeri))
  var listaNum2 = List[Int]()
  listaNum2 = listaNumeri.filter(_ % 2 == 0)
  println(listaNum2)
}

