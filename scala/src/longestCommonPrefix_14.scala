object longestCommonPrefix_14 {
  def main(args: Array[String]): Unit = {
    val input = Array[String]("crt", "cat")
//    val input = Array[String]("flower", "flow", "flight")
    val prefix = longestCommonPrefix(input)
    println(prefix)
  }

  def longestCommonPrefix(strs: Array[String]): String = {
    var preStr = ""
    val firstWord = strs(0)

    firstWord.zipWithIndex.foreach {
      case (f, i) => {
        var tempStr = ""
        val bool: Boolean = strs.forall(str => {
//          if (firstWord.equals(str)) return true // Fail to exclude FirstWord
          i < checkSize(firstWord, str) &&
            (f.equals(str(i))) match {
            case true => tempStr = str(i).toString
                          true
            case false => return preStr
          }
        })
        if (bool) preStr = preStr + tempStr
      }
    }
    preStr
  }

  def checkSize(str: String, str1: String): Int = {
    if (str.length > str1.length) return str1.length
    str.length
  }

  // Other solution
  def longestCommonPrefix2(strs: Array[String]): String = {
    strs.length match {
      case 0 => ""
      case 1 => strs(0)
      case _ =>
        val len = strs.map(x => x.length).min
        for (i <- 0 until len) {
          if (strs.map(x => x(i)).distinct.length > 1) {
            return strs(0).substring(0, i)
          }
        }
        strs(0).substring(0, len)
    }
  }
}
