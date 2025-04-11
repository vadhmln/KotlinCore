import kotlin.system.measureNanoTime

/*
Учитывая целочисленный массив nums, верните массив answer таким образом,
чтобы ответ [i] был равен произведению всех элементов nums, кроме nums[i].
Произведение любого префикса или суффикса nums гарантированно укладывается в
32-разрядное целое число.
Вы должны написать алгоритм, который выполняется за O(n) времени и без
использования операции деления.
*/

fun main() {
    val booleanTest = true

    if (booleanTest) {
    }

    runBenchmark()
//    val nums = intArrayOf(1, 2, 3, 4)
//    val largeArray = IntArray(10000) { it + 1 }
//    val productExceptSelfSolution = ProductExceptSelfSolution()
//    val startTime = System.nanoTime()
//    val result = productExceptSelfSolution.productExceptSelf(nums)
//    val endTime = System.nanoTime()
//    println("Execution time: ${(endTime - startTime) / 1_000_000} ms")
//    println("Result: ${result.joinToString()}")
}

fun runBenchmark() {
    val solution = ProductExceptSelfSolution()

    // Test cases of different sizes
    val testCases =
        mapOf(
            "Small array" to intArrayOf(1, 2, 3, 4),
            "Medium array" to IntArray(1000) { it % 10 + 1 },
            "Large array" to IntArray(100000) { it % 10 + 1 },
        )

    // Warmup phase - run algorithm multiple times to allow JVM to optimize
    println("Warming up JVM...")
    val warmupArray = IntArray(10000) { it % 10 + 1 }
    repeat(1000) {
        solution.productExceptSelf(warmupArray)
    }
    println("Warmup complete")
    println()

    // Benchmark phase
    for ((name, array) in testCases) {
        println("Benchmarking: $name (size: ${array.size})")

        // Run single execution for correctness check
        val result = solution.productExceptSelf(array)
        println("First few elements of result: ${result.take(5).joinToString()}")

        // Run multiple iterations for timing
        val iterations =
            when {
                array.size <= 10 -> 100000
                array.size <= 1000 -> 1000
                else -> 100
            }

        // Measure total time for all iterations
        val totalTimeNs =
            measureNanoTime {
                repeat(iterations) {
                    solution.productExceptSelf(array)
                }
            }

        // Calculate and display statistics
        val avgTimeNs = totalTimeNs / iterations
        val avgTimeMs = avgTimeNs / 1_000_000.0

        println("Iterations: $iterations")
        println("Total time: ${totalTimeNs / 1_000_000} ms")
        println("Average execution time: $avgTimeMs ms")
        println("Average execution time: $avgTimeNs ns")
        println()
    }
}

class ProductExceptSelfSolution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val leftProducts = IntArray(nums.size)
        val rightProducts = IntArray(nums.size)
        val resultProducts = IntArray(nums.size)

        for (i in nums.indices) {
            if (i == 0) {
                leftProducts[i] = 1
            } else {
                leftProducts[i] = leftProducts[i - 1] * nums[i - 1]
            }
        }

        for (i in nums.size - 1 downTo 0) {
            if (i == nums.size - 1) {
                rightProducts[i] = 1
            } else {
                rightProducts[i] = rightProducts[i + 1] * nums[i + 1]
            }
        }

        for (i in resultProducts.indices) {
            resultProducts[i] = leftProducts[i] * rightProducts[i]
        }

        return resultProducts
    }
}

// class ProductExceptSelfSolution {
//    fun productExceptSelf(nums: IntArray): IntArray {
//        var rightProducts = 1
//        val resultProducts = IntArray(nums.size)
//
//        for (i in nums.indices) {
//            if (i == 0) {
//                resultProducts[i] = 1
//            } else {
//                resultProducts[i] = resultProducts[i - 1] * nums[i - 1]
//            }
//        }
//
//        for (i in nums.size - 1 downTo 0) {
//            resultProducts[i] = resultProducts[i] * rightProducts
//            rightProducts *= nums[i]
//        }
//
//        return resultProducts
//    }
// }

// Benchmarking: Small array (size: 4)
// First few elements of result: 24, 12, 8, 6
// Iterations: 100000
// Total time: 4 ms
// Average execution time: 4.8E-5 ms
// Average execution time: 48 ns
//
// Benchmarking: Medium array (size: 1000)
// First few elements of result: 0, 0, 0, 0, 0
// Iterations: 1000
// Total time: 4 ms
// Average execution time: 0.004129 ms
// Average execution time: 4129 ns
//
// Benchmarking: Large array (size: 100000)
// First few elements of result: 0, 0, 0, 0, 0
// Iterations: 100
// Total time: 54 ms
// Average execution time: 0.546774 ms
// Average execution time: 546774 ns
