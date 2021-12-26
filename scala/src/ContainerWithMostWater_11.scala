object ContainerWithMostWater_11 {
  def main(args: Array[String]): Unit = {
    val input = Array(1,8,6,2,5,4,8,3,7) // result = 49
//    val input = Array(1,1)
    val result = maxArea(input)
    println(result)
  }

  def maxArea(height: Array[Int]): Int = {
    var max = 0

    def checkPoint(start: Int, end: Int): Int = {
      if(start >= end) return max
      var h = 0
      var s = start
      var e = end
      if(height(start) > height(end)){
        h = height(end)
        e = end - 1
      } else {
        h = height(start)
        s = start + 1
      }
      val w = end - start
      if(max < h*w) max = h*w
      checkPoint(s, e)
    }

    checkPoint(0,height.length-1)
  }

  def maxArea1(height: Array[Int]): Int = {
    var max = 0

    def checkPoint(start: Int, end: Int): Int = {
      if(start >= end) return max
      // Initialize variables at the same time
      val (h, s, e) = if(height(start) > height(end)) (height(end), start, end - 1) else (height(start), start + 1, end)
      val w = end - start
      if(max < h*w) max = h*w
      checkPoint(s, e)
    }

    checkPoint(0,height.length-1)
  }

  // Other solution
  def maxArea2(height: Array[Int]): Int = {
    var res = 0
    var left = 0
    var right = height.length - 1
    while (left < right) {
      val lh = height(left)
      val rh = height(right)
      if (lh < rh) {
        res = res max (right - left) * lh
        left += 1
      }
      else {
        res = res max (right - left) * rh
        right -= 1
      }
    }
    res
  }

}
