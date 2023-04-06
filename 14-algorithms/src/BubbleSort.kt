import java.util.*
import kotlin.random.Random

private val a = longArrayOf()
private val nElements = 0

fun main() {
    val numbers = arrayOf(3, 5, 2, 10, 100, 34)
//    mySort(numbers.toMutableList())

    val myRandomValues = IntArray(100) { Random.nextInt(0, 100) }
    myRandomValues.bubbleSort()
//    println(myRandomValues.toList())

    val randomIntArray = IntArray(10) { it + 1 }

    randomIntArray.shuffle()
//    randomIntArray.bubbleSort()

    /*
    * Преобразование массива в список делаем исключительно для того, чтобы метод println() корректно отобразил содержимое массива.
    */
//    println(randomIntArray.toList())

//    arraySort(randomIntArray, true)
//    println(randomIntArray.toList())

    val list = ArrayList(IntArray(10) { it + 1 }.toList())

//    println("Original: $list")
//    list.bubbleSort(true)
//    println("Bubble sorted: $list")

//    bSort(randomIntArray)
//    println(randomIntArray.toList())
    test(randomIntArray, true)
    println(randomIntArray.toList())


}

fun bSort(array: IntArray) {
    for (out in array.lastIndex downTo 1) {
        for (current in 0 until out) {
            if (array[current] > array[current + 1]) {
                val temp = array[current + 1]
                array[current + 1] = array[current]
                array[current] = temp
            }
        }
    }
}


private fun swap(one: Int, two: Int) {
    val temp = a[one]
    a[one] = a[two]
    a[two] = temp
}

val numbers = arrayOf<Int>()

fun mySort(numbers: MutableList<Int>): List<Int> {
    for (i in 1 until numbers.size) {             // проделываем = сколько элементов
        for (j in numbers.size - 1 downTo i) {
            if (numbers[j] < numbers[j - 1]) {             // если последний numbers[j] < предпоследнего numbers[j - 1]
                val temp = numbers[j]
                numbers[j] = numbers[j - 1]
                numbers[j - 1] = temp                      // меняем местами
            }
        }
    }
    return numbers
}

fun IntArray.bubbleSort() {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 1 until this.size) {
            val previous = this[i - 1]
            val current = this[i]
            if (previous > current) {
                this.swap(i - 1, i)
                sorted = false
            }
        }
    }
}

fun IntArray.swap(first: Int, second: Int) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}

fun <T : Comparable<T>> ArrayList<T>.bSort(showPasses: Boolean = false) {
    if (this.size < 2) return                        // если коллекция меньше 1 - ничего не делаем
    for (end in this.lastIndex downTo 1) { // При каждом проходе сравниваем на одно значение меньше, сокращаем массив на единицу с каждым проходом
        var swapped = false
        for (current in 0 until end) {     // начинаем с первого элемента и до последнего
            if (this[current] > this[current + 1]) {// сравниваем каждый элемент со смежным
                this.swapAt(current, current + 1)   // меняем значения местами, если это необходимо
                swapped =
                    true                      // помечаем как замененное - завершает сортировку, если список отсортирован

            }
        }
        if (showPasses) println(this)               // для визуализации процесса
        if (!swapped) return                        // Если не было произведено обмена значениями, предполагается, что коллекция отсортирована
    }
}

fun <T> ArrayList<T>.swapAt(first: Int, second: Int) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}

//Cocktail sort

fun shakerSort(arr: IntArray) {
    var temp: Int
    var left = 0
    var right = arr.size - 1
    do {
        for (i in left until right) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
            }
        }
        right--
        for (i in right downTo left + 1) {
            if (arr[i] < arr[i - 1]) {
                temp = arr[i]
                arr[i] = arr[i - 1]
                arr[i - 1] = temp
            }
        }
        left++
    } while (left < right)
}

fun arraySort(intArray: IntArray, showPasses: Boolean) {
    if (intArray.size < 2) return

    for (end in intArray.lastIndex downTo 1) {
        var swapped = false
        for (current in 0 until end) {
            if (intArray[current] > intArray[current + 1]) {
                swap(intArray, current)
                swapped = true
            }
        }
        if (showPasses) println(intArray.toList())
        if (!swapped) return
    }
}

private fun swap(intArray: IntArray, current: Int) {
    val temp = intArray[current + 1]
    intArray[current + 1] = intArray[current]
    intArray[current] = temp
}

fun test(array: IntArray, showPasses: Boolean) {
    if (array.size < 2) return

    for (end in array.lastIndex downTo 1) {
        var swapped = false
        for (current in 0 until end) {
            if (array[current] > array[current + 1]) {
                val temp = array[current + 1]
                array[current + 1] = array[current]
                array[current] = temp
                swapped = true
            }
        }
        if (showPasses) println(array.toList())
        if (!swapped) return
    }
}



