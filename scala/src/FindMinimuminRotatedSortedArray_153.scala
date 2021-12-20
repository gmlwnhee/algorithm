object FindMinimuminRotatedSortedArray_153 {
  def main(args: Array[String]): Unit = {
//    val input = Array(2,3,1)
//    val input = Array(1,2,3,4,5)
    val input = Array(3,4,5,1,2)
    val result = findMin(input)
    println(result)
  }

  def findMin(nums: Array[Int]): Int = {
    findNext(nums, 0, nums.length-1)
  }

  // Main Point : Find Max value
  def findNext(nums: Array[Int], start: Int, end: Int): Int = {
    val mid = (start + end) / 2
    if (mid < nums.length - 1 && start >= end) return nums(mid + 1)
    if (nums(start) < nums(mid)) {
      findNext(nums, mid, end)
    } else if (nums(start) > nums(mid)) {
      findNext(nums, start, mid - 1)
    } else if (nums(end) < nums(mid)) {
      findNext(nums, start, mid)
    } else if (nums(end) > nums(mid)) {
      findNext(nums, mid+1, end)
    } else nums(0)
  }

  // Other solution
  def findMin1(nums: Array[Int]): Int = {
    var (low, high) = (0, nums.length - 1)
    while (low < high) {
      val mid = low + (high - low) / 2
      if (nums(mid) < nums(high)) {
        high = mid
      } else {
        low = mid + 1
      }
    }

    nums(low)
  }
}
