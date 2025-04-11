
/*
A phrase is a palindrome if, after converting all uppercase letters into
lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

fun main() {
    val inputString = "A man, a plan, a canal: Panama"

    val solution = ValidPalindromeSolution()

    println(solution.isPalindrome(inputString))
}

class ValidPalindromeSolution {
    // converting all uppercase letters into lowercase letters
    // removing all non-alphanumeric characters
    // check if it is palindrome

    // первое решение
//    fun isPalindrome(s: String): Boolean {
//        var isInputStringPalindrome = false
//        val charRange = 'a'..'z'
//        val numberRange = '0'..'9'
//
//        val newString = s.lowercase(Locale.getDefault()).filter { it in charRange + numberRange }
//        val reversedString = newString.reversed()
//
//        if (newString == reversedString) {
//            isInputStringPalindrome = true
//        }
//
//        println(newString)
//
//        return isInputStringPalindrome
//    }

    // второе решение
//    fun isPalindrome(s: String) = s.filter { it.isLetterOrDigit() }.run { equals(reversed(), true) }

    // третье решение
//    fun isPalindrome(s: String): Boolean {
//        var l = 0
//        var r = s.length - 1
//
//        while (l < r) {
//            var f = s[l]
//            if (f in 'A'..'Z') {
//                f = ((f - 'A') + 'a'.code).toChar()
//            } else if (f !in 'a'..'z' && f !in '0'..'9') {
//                l++
//                continue
//            }
//
//            var b = s[r]
//            if (b in 'A'..'Z') {
//                b = ((b - 'A') + 'a'.code).toChar()
//            } else if (b !in 'a'..'z' && b !in '0'..'9') {
//                r--
//                continue
//            }
//
//            if (f != b) return false
//
//            l++
//            r--
//        }
//
//        return true
//    }

    // 4 решение
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            // Пропускаем не буквенно-цифровые символы слева
            while (left < right && !s[left].isLetterOrDigit()) {
                left++
            }

            // Пропускаем не буквенно-цифровые символы справа
            while (left < right && !s[right].isLetterOrDigit()) {
                right--
            }

            // Сравниваем символы без учета регистра
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                return false
            }

            left++
            right--
        }

        return true
    }
}
