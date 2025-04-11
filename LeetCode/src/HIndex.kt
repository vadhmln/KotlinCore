/*
Given an array of integers citations where citations[i] is the number of citations a researcher received
for their ith paper, return the researcher's h-index.

The h-index is defined as the maximum value of h such that the given researcher has published at least
h papers that have each been cited at least h times.

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1
*/

fun main() {
    val intArray = intArrayOf(3, 0, 6, 1, 5)

    val hIndexSolution = HIndexSolution()
    println(hIndexSolution.hIndex(intArray))
}

class HIndexSolution {
    fun hIndex(citations: IntArray): Int {
        for (i in citations.lastIndex downTo 1) {
            for (j in 0 until i) {
                if (citations[j] < citations[j + 1]) {
                    citations[j] = citations[j + 1].also { citations[j + 1] = citations[j] }
                }
            }
        }

        var hIndex = 0

        for (index in citations.indices) {
            if (citations[index] >= index + 1) {
                hIndex++
            }
        }

        return hIndex
    }

    fun hIndexBetter(citations: IntArray): Int {
        val n = citations.size
        // Создаем массив для подсчета количества статей с определенным числом цитирований
        val count = IntArray(n + 1)

        // Подсчет публикаций: если citation >= n, учитываем их в последнем элементе.
        for (citation in citations) {
            if (citation >= n) {
                count[n]++
            } else {
                count[citation]++
            }
        }

        // Идем с конца массива и ищем h-индекс
        var total = 0
        for (i in n downTo 0) {
            total += count[i]
            if (total >= i) {
                return i
            }
        }

        return 0
    }
}
