import scala.collection.mutable

object ContainsDuplicate_217 {
  def main(args: Array[String]): Unit = {
//    val input = Array(1,2,1,3,1)
    val input = Array(1,2,3,4)
    val result = containsDuplicate(input)
    println(result)
  }

  def containsDuplicate(nums: Array[Int]): Boolean = {
    val map = mutable.Map[Int, Int]()
    nums foreach(num => {
      // Faster than other my solution
      if(map.get(num).isEmpty) map.put(num,1)
//      if(map.get(num) == None) map.put(num,1)
      else return true
      // All num put
//      map.put(num, map.getOrElse(num, 0)+1)
    })
//    map.foreach(println(_))
    false
  }

  def containsDuplicate2(nums: Array[Int]): Boolean = {
    if(nums.size.equals(nums.distinct.size)) false
    //    if(nums.size == nums.distinct.size) false
    else true
  }

  // Other solution
  def containsDuplicate3(nums: Array[Int]): Boolean = {
    var result = false
    val n = nums.sorted
    for (i <- 0 until n.length - 1) {
      if (n(i) == n(i + 1)) result = true
    }
    result
  }
}
