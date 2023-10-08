package array

fun getMyAverage(list: List<Int>) =
    list.sum() / list.size.toDouble()


fun main() {
    val numbers = listOf(1, 2, 3, 0, 12, 5, 90)
    val list = numbers.map { it * 2 }

    println(getMyAverage(numbers))
    println(list)
}