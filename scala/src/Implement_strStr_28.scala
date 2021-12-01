object Implement_strStr_28 {
  def main(args: Array[String]): Unit = {
    val input_h = ""
    val input_n = ""
    val result = strStr(input_h, input_n)
    println(result)
  }

  def strStr(haystack: String, needle: String): Int = {
    if(haystack.equals("") && needle.equals("")) return 0
    // if(haystack.isBlank && needle.isBlank) return 0
    // if(haystack.length == 0 && needle.length == 0) return 0
    haystack.indexOf(needle)
    }
}
