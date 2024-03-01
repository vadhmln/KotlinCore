import kotlin.system.measureTimeMillis

var operation = 0

fun main() {
    //сравнить первый и второй элементы коллекции
    //если левый элемент больше правого, то меняем местами, иначе - нет
    //перейти на одну позицию вправо - делаем как в первый раз до конца коллекции

    val list = (0..100).toMutableList()
    list.shuffle()
    println("Исходный список: ${list.joinToString()}")

    val elapsedTime = measureTimeMillis {
//        bSort(list)
        myBSort(list)
    }

    println("Отсортированный список: ${list.joinToString()}")
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





























