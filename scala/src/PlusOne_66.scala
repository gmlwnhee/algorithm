import scala.util.control.Breaks._

object PlusOne_66 {
  def main(args: Array[String]): Unit = {
   val digits =  Array(1,9,9)
    val result = plusOne(digits)
    println(result)
    printArray(result)
  }

  def plusOne(digits: Array[Int]): Array[Int] = {
    var arr = digits
    if(arr.last == 9) {
      arr(arr.length -1) = 0
      if(arr.length > 1){
        val arrSub = arr.slice(0,arr.length-1)
        arr = plusOne(arrSub) :+ arr.last
      }else {
        arr = 1 +: arr
      }
    } else {
      arr(arr.length -1) = arr.last + 1
    }
    arr
  }

  def printArray(ints: Array[Int]): Unit ={
    ints.foreach(i => print(i + " "))
  }

  // Other solution 1 - used break
  def plusOne2(digits: Array[Int]): Array[Int] = {
    var result = digits
    breakable {
      for(i <- (digits.size-1) to 0 by -1) {
        if(digits(i) != 9) {
          result(i) += 1
          break
        } else {
          result(i) = 0
          if(i == 0) {
            // case [9] need to convert to [1,0]
            result = Array(1) ++ result
          }
        }
      }
    }
    result
  }

  // Otehr solution 2 - sample 424 ms submission
  def plusOne3(digits: Array[Int]): Array[Int] = {
    var carry = 1
    for (i <- digits.size - 1 to 0 by -1) {
      val sum = digits(i) + carry

      carry = sum / 10

      digits(i) = sum % 10
    }

    if (carry == 0) digits else Array(1) ++ digits
  }
}
