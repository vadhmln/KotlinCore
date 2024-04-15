fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)

    val solution = Solution()

    solution.merge(nums1, 1, nums2, nums2.size)
    println(nums1.joinToString(", "))
}

class Solution {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m - 1
        var p2 = n - 1
        var idx = m + n - 1
        if (nums1.isEmpty() && nums2.isEmpty()) return
        if (nums1.size == 1 && nums2.isEmpty()) return
        if (nums1.size == 1 && nums2.size == 1) {
            nums1[0] = nums2[0]
            return
        }

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[idx] = nums1[p1]
                p1--
            } else {
                nums1[idx] = nums2[p2]
                p2--
            }
            idx--
        }
    }
}