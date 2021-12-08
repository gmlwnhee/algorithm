object addBinary_67 {
  def main(args: Array[String]): Unit = {
    val inputA = "101111"
    val inputB = "10"
//    val inputA = "1"
//    val inputB = "111"
//    val inputA = "1010"
//    val inputB = "1011"
    val result = addBinary(inputA, inputB)
    println(result)
  }

  def addBinary(a: String, b: String): String = {
    var str = ""
    var aa = a
    var bb = b
    val len = a.length - b.length
    if(len > 0) bb = "0" * len + bb
    else if (len < 0) aa = "0" * -len + aa

    for(i <- aa.length-1 to 0 by -1){
      var chkV = aa(i).toString.toInt + bb(i).toString.toInt
      if(str.length == aa.length -i) chkV += str(aa.length-1-i).toString.toInt
      chkV match {
        case 0 if (str.length == aa.length -i) => str = str.slice(0,aa.length-1-i) + "0"
        case 0 => str += "0"
        case 1 if (str.length == aa.length -i) => str = str.slice(0,aa.length-1-i) + "1"
        case 1 => str += "1"
        case 2 => str = str.slice(0,aa.length-1-i) + "01"
        case 3 => str = str.slice(0,aa.length-1-i) + "11"
      }
    }
    str.reverse
  }

  // method changing binary to decimal, but it doesn't convert large number ex) E29
  def binaryToDecimal(str: String): Double = {
    val reverseStr = str.reverse
    var decVal : Double = 0
    for ( i <- 0 to str.size-1) {
      if(reverseStr(i).equals('1'))
        decVal += math.pow(2,i)
    }
    println(decVal)
    decVal
  }

  def decimalToBinary(i: Double): String = {
    var str = ""
    if(i == 0) return str
    else if(i % 2 == 0) str = "0"
    else str = "1"
    str += decimalToBinary((i/2).floor)
    str
  }

  def addBinary1(a: String, b: String): String = {
    if(a.equals("0") && b.equals("0")) return "0"
    val sum = binaryToDecimal(a) + binaryToDecimal(b)
    decimalToBinary(sum).reverse
  }

  // Other solution
  def addBinary2(a: String, b: String): String = {
    (BigInt.apply(a, 2) + BigInt.apply(b, 2)).toString(2)
  }
}
