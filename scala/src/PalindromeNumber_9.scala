object PalindromeNumber_9 {
  def main(args: Array[String]) {
    val input: Int = 10
    val input2: Int = 100
//    val input2: Int = 10222001
//    val input: Int = 1234554321
    val bool =isPalindrome(input)
    val bool2 =isPalindrome(input2)
    println(s"My answer : $bool $bool2")
  }

  def isPalindrome(x: Int): Boolean = {
    if(x < 0) return false
    val charArr = x.toString.toCharArray
    // charArr.size / 2 - 1 이 runtime이 더 오래 걸림
    val size : Int = charArr.size / 2

    for(i <- 0 to size) {
      if(!charArr(i).equals(charArr(charArr.size - 1 - i))) {
        return false
      }
    }
    true

    //    charArr.forall(char => {
    //      // 같은 숫자가 있을 때 indexOf 사용X!!
    //      val index = charArr.indexOf(char)
    //      (index <= size) match {
    //        case true => if(charArr(index).equals(charArr(charArr.size - 1 - index))) {
    //          print(true)
    //          true
    //        }
    //                      else {
    //          print(false)
    //          false
    //        }
    //        case false =>  print(false)
    //          false
    //      }
    //    })
  }

  // Other Solution 1
  def isPalindrome2(x: Int): Boolean = {
    var reversedX = reverseNumber(x)
    reversedX == x
  }

  def reverseNumber(x: Int): Int = {
    var varx = x
    var result = 0

    while (varx != 0) {
      result = result * 10 + varx % 10
      varx /= 10
    }
    result
  }

  // Other Solution 2
  // Simple but, Runtime is 8ms faster than my solution
  def isPalindrome3(x: Int): Boolean = {
    if (x < 0) false else x.toString == x.toString.reverse
  }
}
