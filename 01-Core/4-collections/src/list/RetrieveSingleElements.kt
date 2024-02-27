package list

fun main() {
    // получение элемента в определённой позиции
    val numbers = linkedSetOf("one", "two", "three", "four", "five")
    println(numbers.elementAt(3)) // four // элементы хранятся в порядке возрастания
    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet.elementAt(0)) // four

    // получение первого и последнего элемента
    val numbersNext = listOf("one", "two", "three", "four", "five")
    println(numbersNext.first()) // one
    println(numbersNext.last()) // five

    // elementAtOrNull()/elementAtOrElse()
    val numbersNext1 = listOf("one", "two", "three", "four", "five")
    println(numbersNext1.elementAtOrNull(5)) // null
    println(numbersNext1.elementAtOrElse(5) { index -> "The value for index $index is undefined" }) // The value for index 5 is undefined

    // Получение элемента по условию
    val numbersNext2 = listOf("one", "two", "three", "four", "five", "six")
    println(numbersNext2.first { it.length > 3 }) // three
    println(numbersNext2.last { it.startsWith("f") }) // five
    println(numbersNext2.firstOrNull { it.length > 6 }) // null

    val numbersNext3 = listOf(1, 2, 3, 4)
    println(numbersNext3.find { it % 2 == 0 }) // 2
    println(numbersNext3.findLast { it % 2 == 0 }) // 4

    // Получение элемента с помощью селектора
    val list = listOf<Any>(0, "true", false) // Преобразует каждый элемент в строку и возвращает первый элемент с нужной длиной.
    val longEnough = list.firstNotNullOf { item -> item.toString().takeIf { it.length >= 4 } }
    println(longEnough) // true

    // Получение случайного элемента
    val numbersNext4 = listOf(1, 2, 3, 4)
    println(numbersNext4.random()) // 1

    // Проверка на наличие элемента
    val numbersNext5 = listOf("one", "two", "three", "four", "five", "six")
    println(numbersNext5.contains("four")) // true println("zero" in numbers) // false
    println(numbersNext5.containsAll(listOf("four", "two"))) // true
    println(numbersNext5.containsAll(listOf("one", "zero"))) // false
    println(numbersNext5.isEmpty()) // false
    println(numbersNext5.isNotEmpty()) // true
    val empty = emptyList<String>()
    println(empty.isEmpty()) // true
    println(empty.isNotEmpty()) // false
}