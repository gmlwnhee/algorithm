object Numberof1Bits_191 {
  def main(args: Array[String]): Unit = {
    val input = 0x209 // 00000000000000000000000000001011
//    val input = 0x200000 // 00000000000000000000000010000000
    val result = hammingWeight(input)
    println(result)
  }

  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    var x = n
    val list = List(0x5555555555555555L,0x3333333333333333L ,0x0f0f0f0f0f0f0f0fL,0x00ff00ff00ff00ffL,0x0000ffff0000ffffL )
    for(i <- 0 to 4){
      println(x + "  " + x.toBinaryString + "  " + i)
      val pow = math.pow(2,i).toInt
     x = (x & list(i).toInt) + ((x >> pow) & list(i).toInt)
    }
    x
  }

  // Other solution1
  def hammingWeight1(n: Int): Int = n.toBinaryString.count(_ == '1')

  // Other solution2
  def hammingWeight2(n: Int): Int = {
    def loop(num: Int, acc: Int): Int = {
      println(num + "  " + num.toBinaryString + "  " + acc)
      if (num == 0) acc else loop(num & (num-1), acc + 1)
    }

    loop(n, 0)
  }
}
