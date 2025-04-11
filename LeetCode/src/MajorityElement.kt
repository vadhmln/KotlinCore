/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

fun main() {
    // Test examples
    val solution = MajorityElementSolution()
    println(solution.majorityElement(intArrayOf(3, 2, 3))) // Expected: 3
    println(solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))) // Expected: 2
}

class MajorityElementSolution {
    /**
     * Finds the majority element in an array.
     *
     * Uses the Boyer-Moore Voting Algorithm:
     * 1. Choose the first element as a candidate and set counter = 1
     * 2. Iterate through the array:
     *    - If the current element matches the candidate, increment the counter
     *    - Otherwise, decrement the counter
     *    - If the counter becomes 0, choose the current element as the new candidate
     * 3. At the end, the candidate is the majority element
     *
     * Time complexity: O(n), where n is the size of the array
     * Space complexity: O(1)
     */
    fun majorityElement(nums: IntArray): Int {
        // Initial candidate and counter
        var candidate = nums[0]
        var count = 1

        // Iterate through the array starting from the second element
        for (i in 1 until nums.size) {
            // If counter is 0, choose a new candidate
            if (count == 0) {
                candidate = nums[i]
                count = 1
            }
            // If current element equals the candidate, increment counter
            else if (nums[i] == candidate) {
                count++
            }
            // If current element doesn't equal the candidate, decrement counter
            else {
                count--
            }
        }

        // Return the candidate as the majority element
        return candidate
    }
}
