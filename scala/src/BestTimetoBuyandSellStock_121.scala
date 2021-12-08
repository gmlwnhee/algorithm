object BestTimetoBuyandSellStock_121 {
  def main(args: Array[String]): Unit = {
//    val input = Array(7,2,4,1)
//    val input = Array(3,2,6,5,0,3)
    val input = Array(7,1,5,3,6,4)
    val result = maxProfit(input)
    println(result)
  }

  def maxProfit(prices: Array[Int]): Int = {
    var max = prices(0)
    var min = prices(0)
    var chk = max - min
    // It can't solve problem, ex) 7,2,4,1
//    if(prices(0).equals(prices.max) && prices(prices.size-1).equals(prices.min)) return 0
    // Leetcode doesn't compile next code because Array[Int] and Int using '==' will always yield false
//    if(prices.head == prices.max && prices.tail == prices.min) return 0
    prices.zipWithIndex.foreach{
      case (price, i) => {
        if(price < min && i != prices.size -1) {
          min = price
          max = price
        } else if (price > max && i != 0) {
          max = price
          if(max - min > chk)
            chk = max - min
        }
      }
    }
//    prices.foreach(price => {
//      // It can't solve problem, same number ex) 2,1,2,1,0,1,2
//      if(price < min && !price.equals(prices(prices.size-1))) {
//        min = price
//        max = price
//      } else if(price > max && !price.equals(prices(0))) {
//        max = price
//        if(max - min > chk)
//          chk = max - min
//      }
//    })
    println(max)
    println(min)
    chk
  }

  // Other Solution1
  def maxProfit1(prices: Array[Int]): Int = {
    var min = Int.MaxValue

    var maxProfit = 0

    for (price <- prices){
      maxProfit = Math.max(price - min, maxProfit)
      if (min > price){
        min = price
      }
    }
    maxProfit
  }

  // Other Solution2
  def maxProfit2(prices: Array[Int]): Int =
    prices.foldLeft((Int.MaxValue, 0)) {
      case ((minPrice, maxProfit), price) => (minPrice min price, maxProfit max (price - minPrice))
    }._2
}
