package list

fun main() {
    // groupBy()
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.groupBy { it.first().uppercase() }) // {O=[one], T=[two, three], F=[four, five]}
    println(numbers.groupBy(
        keySelector = { it.first() },
        valueTransform = { it.uppercase() })) // {o=[ONE], t=[TWO, THREE], f=[FOUR, FIVE]} }

    // groupingBy()
    val numbersNext = listOf("one", "two", "three", "four", "five", "six")
    println(numbersNext.groupingBy { it.first() }.eachCount()) // {o=1, t=2, f=2, s=1}
}