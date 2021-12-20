object SumofTwoIntegers_371 {
  def main(args: Array[String]): Unit = {
    val inputA = 1
    val inputB = 2
    val result = getSum(inputA, inputB)
    println(result)
  }

  // If is faster than match
  def getSum(a: Int, b: Int): Int = if(b == 0) a else getSum(a ^ b, (a & b) << 1)

  def getSum2(a: Int, b: Int): Int = {
    b match {
      case 0 => a
      case _ => getSum(a^b,(a&b)<<1)
    }
  }
}
