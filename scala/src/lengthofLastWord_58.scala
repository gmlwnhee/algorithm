object lengthofLastWord_58 {
  def main(args: Array[String]): Unit = {
    val input = "Hello Everyone"
    val result = lengthOfLastWord(input)
    println(result)
  }

  def lengthOfLastWord(s: String): Int = {
    s.split(" ").last.length
    // The above code is faster than these
//    val strArray = s.split(" ")
//    strArray.last.length
  }
}
