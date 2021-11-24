import scala.collection.mutable.Stack

object validParentheses_20 {
  def main(args: Array[String]): Unit = {
    val input = "(){}}{"
//    val input = "("
//    val input = "}"
    val result = isValid(input)
    println(result)
  }

  def isValid(s: String): Boolean = {
    // When I pop at empty stack, it occurs NoSuchElementException (Runtime Error)
    val stack = new Stack[Char]()
//    if(List(')','}',']').contains(s(0))) return false
    s.foreach( c => {
      c match {
        case '(' | '{' | '[' => stack.push(c)
        case ')' => if(stack.isEmpty) return false
                    else if(!stack.pop().equals('(')) return false
        case '}' => if(stack.isEmpty) return false
                    else if(!stack.pop().equals('{')) return false
        case ']' => if(stack.isEmpty) return false
                    else if(!stack.pop().equals('[')) return false
      }
    })
    if(!stack.isEmpty) return false
    true
  }

  // Surprisingly, slower than the above
  def isValid2(s: String): Boolean = {
    val stack = new Stack[Char]()
    s.foreach( c => {
      c match {
        case '(' | '{' | '[' => stack.push(c)
        case ')' => if (stack.isEmpty || !stack.pop().equals('(')) return false
        case '}' => if (stack.isEmpty || !stack.pop().equals('{')) return false
        case ']' => if (stack.isEmpty || !stack.pop().equals('[')) return false
      }
    })
    stack.isEmpty
  }

  // Other solution 1
  def isValid3(s: String): Boolean = {
    val stack = scala.collection.mutable.Stack[Char]()
    for (ch <- s) ch match {
      case '(' | '{' | '[' =>  stack.push(ch)
      case _ =>  if (stack.isEmpty || math.abs(ch - stack.pop) > 2) return false
    }
    stack.isEmpty
  }

  // Other solution 2
  def isValid4(s: String): Boolean = {
    val terminals = Array("()", "[]", "{}")
    s.foldLeft(List[Char]()){(a,v) => a match {
      case x :: xs if (terminals.contains("" + x + v)) => xs
      case _ => v +: a
    }}.isEmpty
  }

}
