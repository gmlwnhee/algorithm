import BasicFunction.printList

object ThreeSum_15 {
  def main(args: Array[String]): Unit = {
    val input = Array(-1,1,0)
//    val input = Array(-1,0,1,2,-1,-4,-1)
    val result = threeSum(input)

    result.foreach(printList(_))
  }

  // Other solution
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums.length < 3) return List.empty[List[Int]]
    var lb = scala.collection.mutable.Set.empty[List[Int]]
    val hm = scala.collection.mutable.Map.empty[Int, Int]

    (0 to nums.length - 2).foreach { idx1 =>
      val num1 = nums(idx1)
      hm.getOrElseUpdate(num1, idx1)
      (idx1 + 1 to nums.length - 1).foreach { idx2 =>
        val num2 = nums(idx2)
        val target = 0 - num1 - num2
        hm.getOrElseUpdate(num2, idx2)

        if(hm.get(target).exists(t => t != idx1 && t != idx2)){
          lb += List(num1, num2, target).sorted
        }
      }
    }

    lb.toList
  }

  // Resolution process
  // combinations is too slow
  def threeSum1(nums: Array[Int]): List[List[Int]] = {
    if(nums.size < 3) return Nil
    nums.combinations(3).map(numArr=> {
      if(numArr(0) + numArr(1) + numArr(2) == 0) numArr.toList
      else Nil
    }).filter(!_.isEmpty).toList
  }

  def threeSum2(nums: Array[Int]): List[List[Int]] = {
    if(nums.size < 3) return Nil
    nums.combinations(3).filter(numArr=> {
      numArr(0) + numArr(1) + numArr(2) == 0
    }).map(_.toList).toList
  }

  // It's wrong answer ex.(1,-2,2,1) -> (-1,0,1) but () is right
//  def threeSum3(nums: Array[Int]): List[List[Int]] = {
//    if(nums.size < 3) return Nil
//    // list.distinct doesn't filter ex.(-1,0,1) (-1,1,0)
//    //    var list = List(List[Int]())
//    var set = Set[List[Int]]()
//    for(i <- 0 to nums.length-1){
//      nums.filter(nums.indexOf(_) != i).fold(0)((a,b)=>{if(nums(i) + a + b == 0) set = set + List(nums(i), a, b).sorted
//        b
//      })
//    }
//    set.toList
//  }
}
