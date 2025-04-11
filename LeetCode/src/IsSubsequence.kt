/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting
some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */
fun main() {
    val firstString = ""
    val secondString = ""
    val isSubsequenceSolution = IsSubsequenceSolution()

    println(isSubsequenceSolution.isSubsequence(firstString, secondString))
}

class IsSubsequenceSolution {
    // версия 1
//    fun isSubsequence(s: String, t: String): Boolean {
//        var left = 0
//        var right = 0
//
//        while (left in s.indices) {
//            while (right in t.indices) {
//                if (left == s.length) break
//                if (s[left] == t[right]) {
//                    left++
//                    right++
//                } else right++
//            }
//            if (right == t.length) break
//        }
//
//        return left == s.length
//    }

    // версия 2
//    fun isSubsequence(s: String, t: String): Boolean {
//        if (s.isEmpty()) return true
//        if (s.length > t.length) return false
//
//        var left = 0
//
//        for (i in t.indices) {
//            if (left < s.length && t[i] == s[left]) {
//                left++
//            }
//            if (left == s.length) break
//        }
//
//        return left == s.length
//    }

    // версия 3 - улучшенная
    fun isSubsequence(
        s: String,
        t: String,
    ): Boolean {
        // Проверка граничных случаев
        if (s.isEmpty()) return true
        if (t.isEmpty()) return s.isEmpty()

        var sIndex = 0 // Указатель для строки s

        // Один проход по строке t
        for (char in t) {
            if (char == s[sIndex]) {
                sIndex++
                // Если нашли все символы строки s, можно сразу завершить
                if (sIndex == s.length) return true
            }
        }

        // Проверяем, все ли символы строки s были найдены
        return sIndex == s.length
    }
}
