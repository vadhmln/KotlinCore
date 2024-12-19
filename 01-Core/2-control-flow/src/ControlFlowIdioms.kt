package control_flow

fun main() {
    // вместо вложенных if-выражений, лучше использовать комбинированные логические операторы:
    val isLoggedIn = false
    val hasValidToken = false
    val isAdmin = false

    val canProceed = isLoggedIn && hasValidToken || isAdmin

    // Пример с вложенными if:
    val canProceedIf: Boolean

    if (isLoggedIn) {
        if (hasValidToken) {
            canProceedIf = true
        } else {
            canProceedIf = false
        }
    } else if (isAdmin) {
        canProceedIf = true
    } else {
        canProceedIf = false
    }

    // еще пример
    fun isUserEligible(isActive: Boolean, hasMembership: Boolean) = isActive && hasMembership

    fun getStatusMessage(isActive: Boolean) = if (!isActive) "User is inactive" else "User is active"

    val userActive = true
    val hasMembership = false

    println("Is user eligible: ${isUserEligible(userActive, hasMembership)}") // false
    println(getStatusMessage(userActive)) // User is active

    // с if
    fun isUserEligibleIf(isActive: Boolean, hasMembership: Boolean): Boolean {
        return if (isActive && hasMembership) {
            true
        } else {
            false
        }
    }

    fun getStatusMessageIf(isActive: Boolean): String {
        return if (!isActive) {
            "User is inactive"
        } else {
            "User is active"
        }
    }

    // Redundant 'if' statement
    fun getStatusRedundant(isActive: Boolean) = if (isActive) true else false

    // должно быть просто
    fun getStatus(isActive: Boolean) = isActive

    // Идиома forEach используется для итерации по коллекциям и выполняет действие для каждого элемента:
    val items = listOf("apple", "banana", "cherry")
    items.forEach { item ->
        println(item)
    }

    // Когда нужно использовать индекс элемента, подходит forEachIndexed:
    val itemsForEachIndexed = listOf("apple", "banana", "cherry")
    itemsForEachIndexed.forEachIndexed { index, item ->
        println("Item at index $index is $item")
    }

    // repeat позволяет выполнить действие несколько раз:
    repeat(5) {
        println("Hello!")
    }

    // В for-цикле с коллекцией можно использовать withIndex:
    val itemsWithIndex = listOf("apple", "banana", "cherry")
    for ((index, item) in itemsWithIndex.withIndex()) {
        println("Item at index $index is $item")
    }

    // Для создания последовательностей с ленивыми вычислениями можно использовать generateSequence:
    val sequence = generateSequence(1) { it + 2 }
    println(sequence.take(5).toList()) // [1, 3, 5, 7, 9]

    // мы можем уточнить значения операторов break или continue с помощью меток
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i == 3) break@loop
        }
    }

    // локальный возврат внутри лямбды
    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // локальный возврат внутри лямбды, то есть к циклу forEach
            print(it)
        }
        print(" выполнится с использованием явной метки(lit@)")
    }

    // более удобно использовать неявные метки
    fun foo2() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // локальный возврат внутри лямбды, то есть к циклу forEach
            print(it)
        }
        print(" выполнится с использованием неявной метки(forEach@)")
    }

    // Прямого эквивалента для break не существует, но его можно смоделировать -
    // добавить еще одну вложенную лямбду и нелокально вернуться из нее.
    fun foo3() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // нелокальный возврат из лямбды к вызывающему run
                print(it)
            }
        }
        print(" выполнится с использованием вложенной метки")
    }

    // Рекурсия может заменить циклы в некоторых случаях
    tailrec fun factorial(n: Int, acc: Int = 1): Int {
        return if (n <= 1) acc else factorial(n - 1, acc * n)
    }
    println(factorial(5)) // 120
}