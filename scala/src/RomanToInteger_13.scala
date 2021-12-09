import scala.collection.mutable

object RomanToInteger_13 {
  def main(args: Array[String]): Unit = {
    val num = romanToInt("IX")
    val num2 = romanToInt("LVIII")
    println(num)
    println(num2)
  }
  def romanToInt(s: String): Int = {
    val map = mutable.HashMap[Char, Int]()
    map.put('I', 1)
    map.put('V', 5)
    map.put('X', 10)
    map.put('L', 50)
    map.put('C', 100)
    map.put('D', 500)
    map.put('M', 1000)

    // The above code is faster than these, and these are quick order
//    val map = Map(('I', 1),('V', 5),('X', 10),('L', 50),('C', 100),('D', 500),('M', 1000))
//    val map = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
//    val map = Map[Char, Int](('I', 1),('V', 5),('X', 10),('L', 50),('C', 100),('D', 500),('M', 1000))
//    val map = Map[Char, Int]('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

    var sum : Int = 0

    for(i <- 0 to s.length-2) {
      val n : Int = s(i) match {
        case 'I' => s(i+1) match {
          case 'V' => -1
          case 'X' => -1
          case _ => map('I')
        }
        case 'X' => s(i+1) match {
          case 'L' => -10
          case 'C' => -10
          case _ => map('X')
        }
        case 'C' => s(i+1) match {
          case 'D' => -100
          case 'M' => -100
          case _ => map('C')
        }
        case _ => map(s(i))
      }
      sum = sum + n
    }
    sum = sum + map(s(s.length-1))
    sum
    }

  // Other solution
  def romanToInt2(s: String): Int = {
    val ss = s.replace("IV","IIII")
      .replace("IX","VIIII")
      .replace("XL","XXXX")
      .replace("XC","LXXXX")
      .replace("CD","CCCC")
      .replace("CM","DCCCC")

    ss.foldLeft(0) {
      case (i,c) if c == 'I' => i+1
      case (i,c) if c == 'V' => i+5
      case (i,c) if c == 'X' => i+10
      case (i,c) if c == 'L' => i+50
      case (i,c) if c == 'C' => i+100
      case (i,c) if c == 'D' => i+500
      case (i,c) if c == 'M' => i+1000
      case (i,_) => i+0
    }
  }
}
