fun main() {
    val nums = intArrayOf(1, 3, 5, 6)

    val searchInsertPositionSolution = SearchInsertPositionSolution()

    println("nums[nums.lastIndex] = ${nums[nums.lastIndex]}")
    println("nums.lastIndex = ${nums.lastIndex}")

    println(searchInsertPositionSolution.searchInsert(nums, 7))

}

class SearchInsertPositionSolution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2

            when {
                nums[middle] == target -> return middle
                nums[middle] < target -> left = middle + 1
                else -> right = middle - 1
            }
        }

        return left
    }
}