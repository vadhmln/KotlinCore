package list

fun main() {
    // операторы plus (+) и minus (-)
    val numbers = listOf("one", "two", "three", "four")

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList) // [one, two, three, four, five]
    println(minusList) // [one, two]

    // операторы plus (+) и minus (-) работают с ассоциативными списками иначе, чем с другими коллекциями
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap + Pair("four", 4)) // {one=1, two=2, three=3, four=4}
    println(numbersMap + Pair("one", 10)) // {one=10, two=2, three=3}
    println(numbersMap + mapOf("five" to 5, "one" to 11)) // {one=11, two=2, three=3, five=5}
}