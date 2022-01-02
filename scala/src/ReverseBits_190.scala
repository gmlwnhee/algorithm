object ReverseBits_190 {
  def main(args: Array[String]): Unit = {
//    val input = BigInt.apply("00000010100101000001111010011100", 2)
    val input = BigInt.apply("11111111111111111111111111111101", 2)
//    val input = 11100
    val result = reverseBits(input.toInt)
      println(result)
  }

  // you need treat n as an unsigned value
  def reverseBits(x: Int): Int = {
    var result = 0
    var position = 0
    var num = x
    while(position < 32){
      if((num & 1) == 1) result += Math.pow(2,31-position).toInt
      if(position == 0 && (num & 1) == 1) result +=1
      num = num >> 1
      position += 1
    }
    result

//    var result = 0
//    var position = 31
//    var num = x
//    while(position >= 0){
//      if((num & 1) == 1) result += Math.pow(2,position).toInt
//      if(position == 31 && (num & 1) == 1) result +=1
//      num = num >> 1
//      position -= 1
//    }
//    result

//    // If input start with 0, it doesn't contain 0
//    val a = x.toBinaryString
//    println(a)
//    var sum = 0
//    for(i <- 0 to a.size-1){
//      println(a(i))
//      sum  = sum + (a(i).toString.toInt * Math.pow(2,i).toInt)
//    }
//    sum
  }

  // Other solution1
  def reverseBits1(x: Int): Int =
    x.toBinaryString.reverse.padTo(32,'0').foldLeft(0)((p,n) => (p << 1) + (n - '0'))

  // Other solution2
  def reverseBits2(x: Int): Int = {
    var n = x
    var r = 0
    (1 to 32).map( i => {
      r = (r << 1) | (n & 1)
      n = n >>> 1
    })
    r
  }

}
