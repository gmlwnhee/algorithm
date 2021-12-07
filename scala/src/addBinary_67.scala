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

  // Other solution
  def addBinary2(a: String, b: String): String = {
    (BigInt.apply(a, 2) + BigInt.apply(b, 2)).toString(2)
  }
}
