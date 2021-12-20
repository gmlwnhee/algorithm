object BasicFunction {
  def printArray(ints: Array[Int]): Unit ={
    ints.foreach(i => print(i + " "))
    println()
  }

  def printList(list: List[Int]): Unit = {
    list.foreach(i => print(i + " "))
    println()
  }
}
