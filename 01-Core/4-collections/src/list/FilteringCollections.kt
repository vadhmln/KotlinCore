package list

fun main() {
    // filter()
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3) // [three, four]

    // Для List и Set функция возвращает результат типа List, для Map возвращается Map.
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
    println(filteredMap) // {key11=11}

    // filterNot()
    val filteredNot = numbers.filterNot { it.length <= 3 }

    // filterIndexed()
    val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5) }

    println(filteredIdx) // [two, four]
    println(filteredNot) // [three, four]

    // filterNot()
    val list = listOf(1, 2, 3, 4, 5)
    val filteredList = list.filterIndexed { index, _ -> index % 2 == 0 } // Результат: [1, 3, 5]

    // filterIsInstance()
    val numbersNext = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    numbersNext.filterIsInstance<String>().forEach {
        println(it.uppercase())
    }
    // В логе будет: All String elements in upper case: TWO FOUR

    // filterNotNull()
    val numbersNext1 = listOf(null, "one", "two", null)
    numbersNext1.filterNotNull().forEach {
        println(it.length) // length is unavailable for nullable Strings
    } // В логе будет: 3 3

    // partition()
    val numbersNext2 = listOf("one", "two", "three", "four")
    val (match, rest) = numbersNext2.partition { it.length > 3 }
    println(match) // [three, four]
    println(rest) // [one, two]

    // Проверочные предикаты
    val numbersNext3 = listOf("one", "two", "three", "four")
    println(numbersNext3.any { it.endsWith("e") }) // true
    println(numbersNext3.none { it.endsWith("a") }) // true
    println(numbersNext3.all { it.endsWith("e") }) // false
    println(emptyList<Int>().all { it > 5 }) // true - бессмысленная истина

    val numbersNext4 = listOf("one", "two", "three", "four")
    val empty = emptyList<String>()
    println(numbersNext4.any()) // true
    println(empty.any()) // false println(numbers.none()) // false
    println(empty.none()) // true
}