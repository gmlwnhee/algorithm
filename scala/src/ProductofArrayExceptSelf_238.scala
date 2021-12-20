import scala.language.postfixOps

object ProductofArrayExceptSelf_238 {
  def main(args: Array[String]): Unit = {
//    val input = Array(1,2,3,4)
    val input = Array(4,3,2,1,2)
    val result = productExceptSelf3(input)
    BasicFunction.printArray(result)
  }

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    var answer = Array[Int]()

    // Can't solve problem because combination order is unpredictable. ex) 4,3,2,1,2 -> first combination(4,3,2,2)
    nums.combinations(nums.length-1).foreach(numCb => {answer = numCb.product +: answer})
    while(answer.length != nums.length){
      answer = answer(0) +: answer
    }

    // Can't solve problem because Time limit exceed.
    for( i <- nums.length -1 to 0 by -1){
      answer = nums.zipWithIndex.filter{ _._2 != i }.map{ _._1 }.product +: answer
//      answer = nums.filter(num => !num.equals(nums(i))).product +: answer
    }
    // Similar to above
    nums.indices.map(x=>{
      nums.zipWithIndex.filter{ _._2 != x }.map{ _._1 }.product}).toArray

    //    // prefix sum ex)(1,2,3,4) => (1,2,6,12)
    //    val answer = Array.ofDim[Int](nums.length)
    //    for ( i <- 0 to nums.length-1){
    //      if(i == 0) answer(0) = nums(0)
    //      else answer(i) = answer(i-1) * nums(i)
    //    }
    answer
  }

  // Other solution1
  def productExceptSelf1(nums: Array[Int]): Array[Int] = {
    // postfix operator product
    nums.indices.map(x => (nums.zipWithIndex filter { case (_, index) => index != x }).unzip._1 product) toArray
  }

  // Other solution2
  def productExceptSelf2(nums: Array[Int]): Array[Int] = {
    val _left = nums.scanLeft(1)(_*_).dropRight(1)
    val _right = nums.scanRight(1)(_*_).tail

    _left zip _right map {case (l,r) => l*r}
  }
  // Other solution3
  def productExceptSelf3(nums: Array[Int]): Array[Int] = {
    val result = Array.ofDim[Int](nums.size)

    result(0) = 1
    var i = 1
    while (i < nums.size){
      // Last result defined here and start from result(1)
      result(i) = result(i-1) * nums(i-1)
      i += 1
    }
//    BasicFunction.printArray(result)

    var buffer = 1
    var j = nums.size-2
    while (j >= 0){
      // product until nums(i-1) * buffer
      // buffer is product from nums(j+1) to nums(0) by -1 ex)last-1 result = result(last-2) * nums(last)
      buffer *= nums(j+1)
      result(j) *= buffer
//      println("j" + j + " b: " + buffer)
//      BasicFunction.printArray(result)
      j -= 1
    }

    result
  }

}
