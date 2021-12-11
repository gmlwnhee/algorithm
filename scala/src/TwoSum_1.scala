object twoSum {
  def main(args: Array[String]) {
    val input = Array(3,3)
    val target = 6
    //    val input = Array(2,7,11,15)
    //    val target = 9
    val array =twoSum(input, target)
    println(s"My answer : $array")
    BasicFunction.printArray(array)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.Map[Int, Int] ()
    var count = 0;
    for(num <- nums){
      val y = target - num
      map.get(y) match {
        case None => {map.put(num,count)}
        case Some(index) => return Array(index,count)
      }
      count = count+1
    }
    Array(0,0)
  }

  //  brute force way
  def twoSum2(nums: Array[Int], target: Int): Array[Int] = {
    var arr : Array[Int] = Array()
    nums.foreach(num => {
      nums.foreach( num2 => {
        // 값으로 index찾기
        val first = nums.indexOf(num)
        val second = nums.lastIndexOf(num2)
        if(first != second && num + num2 == target){
          if(!arr.contains(first) && !arr.contains(second)){
            // 배열을 붙일때는 ++연산자를 이용
            // 앞에 붙일때는 +:, 뒤에 붙일때는 :+ 연산자
            arr ++= Array(first, second)
          }
        }
      })
    })
    arr
  }

}
