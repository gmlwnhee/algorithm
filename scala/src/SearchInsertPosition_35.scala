object SearchInsertPosition_35 {
  def main(args: Array[String]): Unit = {
    val inputNums = Array(3,6,7,8,10)
//    val inputNums = Array(-1,1,3,5)
    val targetNum = 4
//    val targetNum = 5
    val result = searchInsert(inputNums, targetNum)
    println(result)
  }

  def searchInsert(nums: Array[Int], target: Int): Int = {
    if(target < nums(0)) return 0

    // find near num
    var min = nums(0) - target
    nums.foreach(num => {
      val v = num - target
      if(v.abs < min.abs) min = v
    })

    if(min != 0 && min < 0) nums.indexOf(target + min) + 1
    else if(min != 0 && min > 0) nums.indexOf(target + min)
    else nums.indexOf(target)
  }

  // Other solution 1
  def searchInsert1(nums: Array[Int], target: Int): Int =
    if (nums contains target) nums indexOf target else nums.length - nums.dropWhile(target >= _).length


  // Other solution 2
  def searchInsert2_BinarySearch(nums: Array[Int], target: Int): Int = {

    var (low, high) = (0, nums.length - 1)
    while (low <= high) {
      val mid = (low + high) / 2
      if (target == nums(mid)) return mid
      else if (target > nums(mid)) low = mid + 1 else high = mid - 1
    }
    low
  }

  // Other solution 3
  def searchInsert3(nums: Array[Int], target: Int): Int = {
    nums.zipWithIndex.find(_._1 >= target) match {
      case Some((e, i)) => i
      case None => nums.length
    }
  }
}
