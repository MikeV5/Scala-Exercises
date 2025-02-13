object Gerarchia_Classi extends App{


  class Box[-T](value: T)

  val numberBox: Box[Number] = new Box(3.14)


}
