fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7)

    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        val shift = k % n

        fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
        val sets = gcd(k, n)

        for (i in 0 until sets) {
            var current = nums[i]
            var j = i

            do {
                val nextPos = (j + shift) % n
                val temp = nums[nextPos]
                nums[nextPos] = current
                current = temp
                j = nextPos
            } while (j != i)
        }
    }

    rotate(numbers, 3)

    println(numbers.joinToString())
}