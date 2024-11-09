// Использование const для компиляторного времени
const val PI = 3.14159

fun main() {
    // Инициализация при использовании lateinit
    lateinit var someString: String

    fun initializeString() {
        someString = "Initialized!"
    }

    // Использование by lazy для ленивой инициализации
    val expensiveValue: String by lazy {
        // Вычисление будет выполнено только при первом доступе
        "Result of a costly operation"
    }

    // Destructuring для работы с несколькими значениями
    val (firstName, lastName) = "John Doe".split(" ")

    // Swap двух переменных с использованием also без использования временной переменной - temp
    var a = 1
    var b = 2
    a = b.also { b = a }

    // Обработка null через Elvis-оператор
    val name: String? = null
    val displayName = name ?: "Unknown"

    // Переменные, зависящие от условий с использованием when
    val type = 2
    val result = when (type) {
        1 -> "One"
        2 -> "Two"
        else -> "Unknown"
    }

    // val переменные можно инициализировать разными значениями в зависимости от некоторых условий,
    // если компилятор сможет гарантировать, что выполнится только одно из инициализирующих выражении
    val canPerformOperation = true
    val message: String = if (canPerformOperation) {
        "Success"
    } else {
        "Failed"
    }

    // Инициализация значений через оператор takeIf
    val number: Int? = 5.takeIf { it > 0 }  // Вернет 5, так как условие true

    // Инициализация через takeUnless
    val numberUnless: Int? = 1.takeUnless { it >= 0 }   // Вернет 1, так как условие false

    // максимальное значение из двух переменных без блоков if-else
    // c if-else
    val d = 1000
    val c = 10
    val maxTwo = if (d > c) d else c
    // без блоков if-else
    val maxAtLeast = d.coerceAtLeast(c)

    // Проверка наличия значения в коллекции
    val items = listOf("apple", "banana", "orange")
    val isApplePresent = "apple" in items // true, если в списке есть "apple"

    // Проверка на null-значение
    val someValue: String? = getSomeValue()
    val isValuePresent = someValue != null // true, если someValue не null

    // Проверка строки на пустоту
    val nameJohn: String? = "John Doe"
    val hasName = !nameJohn.isNullOrEmpty() // true, если nameJohn не null и не пустая строка

    // Проверка условия с использованием let
    val value: Int? = 42
    val isEven = value?.let { it % 2 == 0 } ?: false // true, если value четное и не null

    // Использование any для проверки условий в списке
    val numbers = listOf(1, 2, 3, 4, 5)
    val hasEven = numbers.any { it % 2 == 0 } // true, если есть хотя бы одно четное число

    // Проверка выполнения функции
    fun isDatabaseConnected(): Boolean {
        // логика проверки подключения к базе данных
        return true // или false в зависимости от состояния подключения
    }

    val isConnected = isDatabaseConnected() // true или false в зависимости от результата функции

    // val означает, что ссылка на объект не может быть изменена. Однако, это не означает, что сам объект неизменяем. Если объект является изменяемым, как ArrayList или MutableList, вы можете изменять его состояние (добавлять, удалять или изменять элементы). Но если объект является неизменяемым, как List или String, вы не сможете изменить его состояние:
    val languages = listOf("Java")  // Объявление неизменяемой ссылки и List
    //languages.add("Kotlin")  // Это вызовет ошибку компиляции, потому что список неизменяем
    val mutableLanguages = mutableListOf("Java")  // Объявление неизменяемой ссылки и MutableList
    mutableLanguages.add("Kotlin")  // Изменение объекта допустимо, потому что список изменяем
}

fun getSomeValue(): String? {
    TODO("Not yet implemented")
}

data class MyPerson(var name: String = "", var age: Int = 0)

