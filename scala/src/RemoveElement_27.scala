object RemoveElement_27 {
  def main(args: Array[String]): Unit = {
    val inputArray = Array(1,2,3,4,3)
    val input = 3
    val result = removeElement(inputArray, input)
    println(result)
  }

  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var i = 0
    nums.indices.foreach(j => {
      if(nums(j) != `val`){
       nums(i)= nums(j)
        i += 1
      }
    })
    nums foreach (println(_))
    i
  }
}
