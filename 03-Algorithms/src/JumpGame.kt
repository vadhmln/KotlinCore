fun main() {
    val numbers = intArrayOf(2,3,0,1,4)

    val text: Any

//    fun canJump(nums: IntArray): Boolean {
//        var targetIndex = nums.size - 1
//        for (i in nums.size - 2 downTo 0) {
//            if (i + nums[i] >= targetIndex) targetIndex = i
//        }
//        return targetIndex == 0
//    }

    fun canJump(nums: IntArray): Int {
        var jumps = 0
        var elementForJump = 0
        val targetIndex = nums.size - 1
        println("targetIndex = $targetIndex")
        println("nums.size - 2 = ${nums.size - 2}")
        for (i in nums.size - 2 downTo 0) {
            println("iteration $i jump = ${nums[i]}")
            elementForJump += nums[i]
            if (elementForJump >= targetIndex) {
                jumps++
                break
            } else {
                jumps++
            }
        }
        return jumps
    }

    println(canJump(numbers))
}





