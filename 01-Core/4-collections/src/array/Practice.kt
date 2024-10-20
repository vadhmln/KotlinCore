package array

fun main() {

    val intArray = intArrayOf(3, 3, 2, 3)

    println("Before ${intArray.joinToString(",")}")

    changeIntArray(intArray, 3)
    println("After ${intArray.joinToString(",")}")
}

fun changeIntArray(intArray: IntArray, element: Int) {
    val first = intArray.first { it != element }
    for (i in intArray.indices) {
        if (intArray[i] == element) {
            intArray[i] = first
        }
    }
}