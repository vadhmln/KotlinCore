package list

fun main() {
    // slice() - возвращает список элементов коллекции по указанным индексам
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3)) // [two, three, four]
    println(numbers.slice(0..4 step 2)) // [one, three, five]
    println(numbers.slice(setOf(3, 5, 0))) // [four, six, one]

    // take()/ takeLast()/ drop() и dropLast()
    val numbersNext = listOf("one", "two", "three", "four", "five", "six")
    println(numbersNext.take(3)) // [one, two, three]
    println(numbersNext.takeLast(3)) // [four, five, six]
    println(numbersNext.drop(1)) // [two, three, four, five, six]
    println(numbersNext.dropLast(5)) // [one]

    // takeWhile()/ takeLastWhile()/ dropWhile() и dropLastWhile()
    val numbersNext1 = listOf("one", "two", "three", "four", "five", "six")
    println(numbersNext1.takeWhile { !it.startsWith('f') }) // [one, two, three]
    println(numbersNext1.takeLastWhile { it != "three" }) // [four, five, six]
    println(numbersNext1.dropWhile { it.length == 3 }) // [three, four, five, six]
    println(numbersNext1.dropLastWhile { it.contains('i') }) // [one, two, three, four]

    // chunked()
    val numbersNext2 = (0..13).toList()
    println(numbersNext2.chunked(3)) // [[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10, 11], [12, 13]]
    println(numbersNext2.chunked(3) { it.sum() }) // [3, 12, 21, 30, 25]

    // windowed()
    val numbersNext3 = listOf("one", "two", "three", "four", "five")
    println(numbersNext3.windowed(3)) // [[one, two, three], [two, three, four], [three, four, five]]
    val numbersNext4 = (1..10).toList()
    println(numbersNext4.windowed(3, step = 2, partialWindows = true)) // [[1, 2, 3], [3, 4, 5], [5, 6, 7], [7, 8, 9], [9, 10]]
    println(numbersNext4.windowed(3) { it.sum() }) // [6, 9, 12, 15, 18, 21, 24, 27]

    // zipWithNext()
    val numbersNext5 = listOf("one", "two", "three", "four", "five")
    println(numbersNext5.zipWithNext()) // [(one, two), (two, three), (three, four), (four, five)]
    println(numbersNext5.zipWithNext() { s1, s2 -> s1.length > s2.length}) // [false, false, true, false]
}
