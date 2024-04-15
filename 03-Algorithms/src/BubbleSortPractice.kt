import java.util.ArrayList
import kotlin.system.measureTimeMillis

var operation = 0

    val testList = mutableListOf(9, 8, 7, 6, 5, 4)
fun main() {
    //сравнить первый и второй элементы коллекции
    //если левый элемент больше правого, то меняем местами, иначе - нет
    //перейти на одну позицию вправо - делаем как в первый раз до конца коллекции

    val list = (0..100).shuffled().toMutableList()
    println("Исходный список: ${testList.joinToString()}")

    val elapsedTime = measureTimeMillis {
//        bSort(list)
//        list.bSortNext() // 2 мс
//        myBSort(list) // 2 мс
//        list.bSortNew() // 5 мс
//        list.bSortNextVar() // 5 мс
        testList.bSortNext()
    }

    println("Отсортированный список: ${testList.joinToString()}")
    println("Время выполнения: $elapsedTime мс")
    println("Количество операций: $operation")
}

// брут вариант
fun bSort(numbers: MutableList<Int>) {
    for (j in 0 until numbers.size) {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] > numbers[i + 1]) {
                val temp = numbers[i]
                numbers[i] = numbers[i + 1]
                numbers[i + 1] = temp
                operation++
            }
        }
    }
}

// оптимизация уменьшения верхней границы на i на каждом проходе внешнего цикла
// обменивает значения list[j] и list[j + 1] без необходимости в дополнительной временной переменной
fun myBSort(list: MutableList<Int>) {
    for (i in list.indices) {
        for (j in 0 until list.size - i - 1) { // уменьшения верхней границы на i
            if (list[j] > list[j + 1]) {
                list[j] = list[j + 1].also { list[j + 1] = list[j] } // обменивает значения list[j] и list[j + 1]
                operation++
            }
        }
    }
}

fun myBSortNext(list: MutableList<Int>) {
    for (i in list.indices) {
        for (j in 0 until list.size - i - 1) { // уменьшения верхней границы на i
            if (list[j] > list[j + 1]) {
                list[j] = list[j + 1].also { list[j + 1] = list[j] } // обменивает значения list[j] и list[j + 1]
                operation++
            }
        }
    }
}

fun <T : Comparable<T>> MutableList<T>.bSortNew() {
    if (this.size < 2) return
    this.indices.reversed().forEach { end ->
        var swapped = false
        (0 until end).forEach { current ->
            if (this[current] > this[current + 1]) {
                this[current] = this[current + 1].also { this[current + 1] = this[current] }
                swapped = true
            }
        }
        if (!swapped) return
    }
}

fun <T : Comparable<T>> MutableList<T>.bSortNext() {
    if (this.size < 2) return                        // если коллекция меньше 1 - ничего не делаем
    for (end in this.lastIndex downTo 1) { // При каждом проходе сравниваем на одно значение меньше, сокращаем массив на единицу с каждым проходом
        var swapped = false
        for (current in 0 until end) {     // начинаем с первого элемента и до последнего
            if (this[current] > this[current + 1]) {// сравниваем каждый элемент со смежным
                this[current] = this[current + 1]
                    .also { println("Текущий элемент ${this[current]} Следующий элемент ${this[current + 1]}") }   // меняем значения местами, если это необходимо
                    .also { this[current + 1] = this[current] }
                println("end = $end")
                println(testList)
                swapped = true    // помечаем как замененное - завершает сортировку, если список отсортирован
            }
        }
        if (!swapped) return                        // Если не было произведено обмена значениями, предполагается, что коллекция отсортирована
    }
}

fun <T : Comparable<T>> MutableList<T>.bSortNextVar() {
    if (this.size < 2) return
    this.indices.reversed().forEach { end ->
        var swapped = false
        (0 until end).forEach { current ->
            if (this[current] > this[current + 1]) {
                this[current] = this[current + 1].also { this[current + 1] = this[current] }
                swapped = true
            }
        }
        if (!swapped) return
    }
}


// брут вариант
fun sort(list: MutableList<Int>) {
    for (i in list.indices) {
        for (current in 0 until list.size - 1) {
            if (list[current] > list[current + 1]) {
                val temp = list[current]
                list[current] = list[current + 1]
                list[current + 1] = temp
            }
        }
    }
}

//ограничить верхний предел
fun sortV1(list: MutableList<Int>) {
    for (end in list.lastIndex downTo 1) {
        for (current in 0 until end) {
            if (list[current] > list[current + 1]) {
                val temp = list[current]
                list[current] = list[current + 1]
                list[current + 1] = temp
            }
        }
    }
}

//обойтись без временной переменной
fun sortV2(list: MutableList<Int>) {
    for (end in list.lastIndex downTo 1) {
        for (current in 0 until end) {
            if (list[current] > list[current + 1]) {
                list[current] = list[current + 1].also { list[current+ 1] = list[current] }
            }
        }
    }
}

//проверки
fun sortV3(list: MutableList<Int>) {
    if (list.size < 2) return
    for (end in list.lastIndex downTo 1) {
        var swapped = false
        for (current in 0 until end) {
            if (list[current] > list[current + 1]) {
                list[current] = list[current + 1].also { list[current+ 1] = list[current] }
                swapped = true
            }
        }
        if (!swapped) return
    }
}


































