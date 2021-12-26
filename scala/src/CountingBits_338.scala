object CountingBits_338 {
  def main(args: Array[String]): Unit = {
    val input = 5
    val result = countBits(input)
    BasicFunction.printArray(result)
  }

  def countBits(n: Int): Array[Int] = {
    var arr = Array(0)
    if(n == 0) return arr
    for(i <- 1 to n) {
      arr = arr :+ i.toBinaryString.count(_ == '1')
    }
    arr
  }

  def countBits1(n: Int): Array[Int] = {
    // Compare empty array and Array(0) Above code is faster than this
    var arr = Array[Int]()
    for(i <- 0 to n) {
      arr = arr :+ i.toBinaryString.count(_ == '1')
    }
    arr
  }

  def countBits2(n: Int): Array[Int] = {
    var arr = Array(0)
    if(n == 0) return arr
    for(i <- 1 to n) {
      // Add front is faster than add behind
      arr = i.toBinaryString.count(_ == '1') +: arr
    }
    // But reverse function is slow?
    arr.reverse
  }

  // Other solution1
  def countBits3(n: Int): Array[Int] = {
    val dp = Array.fill(n + 1)(0)
    for (i <- 1 to n) {
      dp(i) = dp(i & (i-1)) + 1
    }
    dp
  }

  // Other solution2
  def countBits4(n: Int): Array[Int] = {
    val arr = Array.fill(n+1)(0)
    if (n == 0) return Array(0)
    arr(0) = 0
    arr(1) = 1

    for (i <- 2.to(n)){
      if (i%2 == 0){
        arr(i) = arr(i/2)
      } else {
        arr(i) = arr(i/2) + 1
      }
    }
    arr
  }

  // Other solution3
  def countBits5(n: Int): Array[Int] = {
    val memo = Array.fill(n + 1)(0)
    for (i <- 1 to n)
      memo(i) = memo(i >> 1) + i % 2
    memo
  }
}
