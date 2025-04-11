package list

fun main() {
    // группа map - лямбда-функции к каждому её элементу, объединяя результаты в новую коллекцию
    val numbers = listOf(1, 2, 3)
    val newNumbers = numbers.map { it * 3 }
    println("Преобразованная коллекция - $newNumbers") // 3, 6, 9
    println("Исходная коллекция $numbers") // исходная коллекция сохраняется 1, 2, 3
}