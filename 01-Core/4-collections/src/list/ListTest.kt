package list

fun main() {
    val nonNulls = listOfNotNull("a", null, "b", "c")

    println(nonNulls.joinToString())
}