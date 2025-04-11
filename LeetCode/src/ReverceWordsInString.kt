fun main() {
    val string = "the sky is blue"

    val solution = MySolution()
    println(solution.reverseWords(string))

}

class MySolution {
    fun reverseWords(s: String): String {
        val words = s.trim().split(" ").toTypedArray()
        var (left, right) = Pair(0, words.size - 1)

        while (left < right) {
            words[left] = words[right].also { words[right--] = words[left++] }
        }

//        return s.trim().split(" ").reversed().joinToString(" ")

        return words.joinToString(" ")
    }



//    fun reverseWords(s: String): String {
//        return s.trim()
//            .split("\\s+".toRegex())  // Split by any whitespace
//            .reversed()               // Reverse word order
//            .joinToString(" ")        // Join with single spaces
//    }

//    fun reverseWords(s: String): String {
//        // Use StringBuilder for efficient string manipulation
//        val result = StringBuilder()
//        var word = StringBuilder()
//
//        // Single pass through the string - O(n)
//        for (i in s.length - 1 downTo 0) {
//            if (s[i] != ' ') {
//                word.insert(0, s[i])
//            } else if (word.isNotEmpty()) {
//                if (result.isNotEmpty()) result.append(' ')
//                result.append(word)
//                word.clear()
//            }
//        }
//
//        // Handle the first word
//        if (word.isNotEmpty()) {
//            if (result.isNotEmpty()) result.append(' ')
//            result.append(word)
//        }
//
//        return result.toString()
//    }
}