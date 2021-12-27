import scala.collection.mutable

object MissingNumber_268 {
  def main(args: Array[String]): Unit = {
    val input = Array(3,0,1)
//    val input = Array(2,0,1)
    val result = missingNumber(input)
    println(result)
  }

  // used sorting
  def missingNumber(nums: Array[Int]): Int = {
    // 488 ms, faster than 100.00% of Scala online submissions
    val sorted = nums.sorted
    for(i <- 0 to sorted.length-1){
      if(sorted(i) != i) return i
    }

//    // second in Sorting solution
//    sorted.indices.foreach(i => {
//      if(sorted(i) != i) return i
//    })

//    // slowest in Sorting solution
//    nums.sorted.zipWithIndex.foreach {
//      case (num ,i) => {
//        if(num != i) return i
//      }
//    }
    // length is faster than size
    nums.length
  }

  // used hashmap
  def missingNumber1(nums: Array[Int]): Int = {
    val map = mutable.HashMap[Int, Int]()
    nums.foreach(num => {
      map.put(num, 1)
    })
    // 0 to nums.length -1 is less than until
    for(i <- 0 until nums.length){
      map.get(i) match {
        case Some(v) =>
        case None => return i
      }
    }
    nums.length
  }

  // Other solution1
  def missingNumber2(nums: Array[Int]): Int = {
    var n = 0
    for (i <- 0 to nums.size) n^=i
    for (el <- nums) n^=el
    n
  }

  // Other solution2
  def missingNumber3(nums: Array[Int]): Int = {
    val ordered = Array.fill(nums.length + 1)(-1)

    nums.indices.foreach { i =>
      ordered(nums(i)) = 1
    }

    ordered.indices.find(i => ordered(i) == -1).getOrElse(nums.length)
  }

  // Other solution3 - used math1
  def missingNumber4(nums: Array[Int]): Int = {
    nums.foldLeft(
      nums.length * (nums.length + 1) / 2
    )(_ - _)
  }

  // Other solution4 - used math2
  def missingNumber5(nums: Array[Int]): Int = {
    val n = nums.length
    ((n + 1) * n / 2) - nums.sum
  }
}
