val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2) // [0,1,4,0,3] [0,1,3,0,4]
val `val` = 2

fun main() {
    val solutionRemoveElement = SolutionRemoveElement()
    val result = solutionRemoveElement.removeElement(nums, `val`)

    println(nums.joinToString(","))
    println(result)
}

class SolutionRemoveElement {
    fun removeElement(
        nums: IntArray,
        element: Int,
    ): Int {
        var j = 0
        for (i in nums.indices) {
            if (nums[i] != element) {
                nums[j] = nums[i]
                j++
            }
        }
        return j
    }

    fun removeElementFunc(
        nums: IntArray,
        element: Int,
    ): Int {
        val filteredNums = nums.filter { it != element }
        for (i in filteredNums.indices) {
            nums[i] = filteredNums[i]
        }
        return filteredNums.size
    }
}
