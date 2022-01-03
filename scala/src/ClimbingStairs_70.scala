import scala.collection.mutable

object ClimbingStairs_70 {
  def main(args: Array[String]): Unit = {
    val input = 3
    val result = climbStairs(input)
    println(result)
  }

  // Memory Limit Exceeded
  def climbStairs(n: Int): Int = {
    var cnt = 0
    climbStep(1, n)
    climbStep(2, n)

    def climbStep(i: Int, remain: Int): Int = {
      var value = remain
      value -= i
      if(value == 0) cnt += 1
      else{
        if(value > 0) climbStep(1, value)
        if(value > 1) climbStep(2, value)
      }
      cnt
    }

    if(n < 3) return n
    cnt
  }

  // Other solution1
  def climbStairs1(n: Int): Int = {
    val solutions: mutable.Map[Int, Int]= mutable.Map[Int, Int]()
    def answer(n: Int): Int = {
      if (n < 0) 0
      else if (n == 0) 1
      else {
        solutions.getOrElse(n, {
          solutions(n) = answer(n - 1) + answer(n - 2)
          solutions(n)
        })
      }
    }

    answer(n)
  }

  // Other solution2
  def climbStairs2(n: Int): Int = {
    var a = 1
    var b = 1
    var c = 1
    for (i <- 0 until n-1) {
      c = a + b
      a = b
      b = c
    }
    c
  }

  // Other solution3
  def climbStairs3(n: Int, a: Int = 0, b: Int = 1): Int = {
    if (n==0) b
    else climbStairs3(n - 1, b, a + b)
  }

  // Other solution4
  def climbStairs4(n: Int, a: Int = 0, b: Int = 1): Int = {
    (1 to n).foldLeft((0, 1)) { case ((a, b), _) => (b, a + b) }._2
  }
}
