package control_flow

val numbers: MutableList<Int?> = (0 .. 10).toMutableList()

fun main() {
    println(numbers.joinToString())
    for (index in numbers.indices) {
        if (numbers[index]?.let { it % 2 == 0 } == true ) {
           numbers[index] = null
        }
    }
    println(numbers.joinToString())
}