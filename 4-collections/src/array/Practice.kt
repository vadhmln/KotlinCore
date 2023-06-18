package array

fun getMyAverage(list: List<Int>): Double {
    var sum: Long = 0
    for (element in list) {
        sum += element.toLong()
    }
    return sum.toDouble() / list.size
}