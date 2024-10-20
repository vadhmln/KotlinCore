package control_flow

fun main() {
    // для перебора чего-либо, имеющего переопределенный метод iterator с модификатором operator
    val fruits = listOf("apple", "banana", "cherry")

    // iterate over elements with indices
    val names = listOf("Alex", "Bob", "Celina")
    for (i in names.indices) {
        val name = names[i]
        println("[$i] $name")
    } // [0] Alex [1] Bob [2] Celina

    for ((i, name) in names.withIndex()) {
        println("[$i] $name")
    }

    for (fruit in fruits) {
        println(fruit)
    }

    // если не требуется управление циклом (break, continue) можно:
    fruits.forEach { fruit ->
        println(fruit)
    }

}