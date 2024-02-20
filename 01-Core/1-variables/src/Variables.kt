import kotlin.math.sqrt

// объявлять глобальные переменные (свойства верхнего уровня) за пределами блока класса
const val CAT_NAME_COMPILE_TIME = "Мурзик" // можно
val CAT_NAME_RUNTIME = "Мурзик" // тоже можно

//const val CAT_NAME_SECOND = getCompanyName() // нельзя, нужно сразу присвоить значение без вычислений
val catNameSecondNext = getCompanyName() // а так можно

class CatsManager {

    fun printCatName(name: String) {
        println(name)
    }

    fun printConstCatNameAtCompileTime() {
        println(CAT_NAME_COMPILE_TIME)
    }

    fun printConstCatNameAtRuntime() {
        println(CAT_NAME_RUNTIME)
    }
}

fun getName() = "Mickey"

fun main() {
    // Чтобы создать переменную, компилятор должен знать три вещи:
    // Возможно ли повторное использование переменной - val/var
    // Имя переменной - необходимо для обращения к значению переменной в коде
    // Тип переменной

    // Неизменяемые (только для чтения) локальные переменные определяются с помощью ключевого слова
    // val (от value) - неизменяемая ссылка. Таким переменным нельзя присвоить значение после инициализации.
    // val переменные - соответствуют финальным (final) переменным в Java
    val immutableValue: Int = 1   // Инициализация при объявлении
    val b = 1        // Тип `Int` определен автоматически
    val c: Int       // Указывать тип обязательно, если переменная не инициализирована сразу
    c = 1            // Последующее присвоение

    // Изменяемые переменные объявляются с помощью ключевого слова var (от variable) - изменяемая ссылка.
    // Такое объявление соответствует обычной (не final) переменной в Java.
    var mutableVariable = 5 // с повторным использованием
    mutableVariable += 1

    // для хранения количества - переменная-счетчик
    var counter = 0
    for (i in 1..100) counter += 1 // 100

    // переменная-флаг
    val isSomethingTrue = true

    // используйте пробелы только с обратными кавычками:
    val `good name` = 5

    /*
     * Переменная, объявленная с ключевым словом val, должна быть инициализирована только один раз
     * во время выполнения блока, в котором она определена.
     * Но её можно инициализировать разными значениями в зависимости от некоторых условий,
     * если компилятор сможет гарантировать, что выполнится только одно из инициализирующих выражении
     */
    val canPerformOperation = true
    val message: String = if (canPerformOperation) {
        "Success"
    } else {
        "Failed"
    }
    println(message)//Success

    /*
     * В Kotlin, val означает, что ссылка на объект не может быть изменена.
     * Однако, это не означает, что сам объект неизменяем. Если объект является изменяемым,
     * как ArrayList или MutableList, вы можете изменять его состояние (добавлять, удалять или изменять элементы).
     * Но если объект является неизменяемым, как List или String, вы не сможете изменить его состояние. Вот пример:
     */
    val languages = listOf("Java")  // Объявление неизменяемой ссылки и List
//    languages.add("Kotlin")  // Это вызовет ошибку компиляции, потому что список неизменяем

    val mutableLanguages = mutableListOf("Java")  // Объявление неизменяемой ссылки и MutableList
    mutableLanguages.add("Kotlin")  // Изменение объекта допустимо, потому что список изменяем

    //var позволяет менять значение переменной, но её тип фиксирован
//    var myNumber = 30
//    myNumber = "Text" //type mismatch error

    /*Если нужно сохранить в переменной значение другого типа,
     *необходимо преобразовать его вручную или привести к нужному типу.
     */

    val long = 3.14
    var int = 0
    int = long.toInt()

    //Когда значение неизвестно во время объявления и не изменяется после инициализации,
    // необходимость использовать var вызывает досаду, потому что вынуждает использовать тип с поддержкой null
//    var name: String? = null
//    name = getName()

    //можете использовать определенное значение для представления неинициализированной ссылки
    var nameNotInitialized: String = "NOT_INITIALIZED_YET"
    nameNotInitialized = getName()

    println("$long")

    //Способы присваивания значения переменным:

    //добавление литерала после знака равенства
    val x = 12

    //присвоить значение одной переменной другой
    val ab = 10
    val bana = ab

    //использовать выражение (if, when, try) или:
    val cana = ab + b

    //лямбда выражение
    val sumNumbers = { a: Int, b: Int -> a + b }

    //анонимная функция
    val anonymousFunction = fun(a: Int, b: Int) = a + b

    //функция/конструктор с соответствующим возвращаемым типом
    val number = returnNewNumber(10)
    val person = Person()

    //объектное выражение или объявление объекта
    val instance = object {} // объектное выражение

    // ссылка на элемент
    fun add(a: Int, b: Int) = a + b
    val funcRef = ::add // function reference

    data class Number(val num: Int)

    //    {
//        fun toFloat(): Float = num.toFloat()
//    }
    // member function reference
//    val float: (Number) -> Float = Number::toFloat
    // extension function reference
    fun Number.toFloat(): Float = num.toFloat()
    val floatExFunRef: (Number) -> Float = Number::toFloat
    // дженерики - List<Int>
    val teamPoints = TeamPoints(listOf(1, 3, 5))
    val sum = teamPoints.calculatePoints(List<Int>::sum) // 9
    // reference a method on an object instance
    // bounded function reference
    val num = Number(10)
    val getNumAsFloat: () -> Float = num::toFloat

    // constructor reference
    data class Complex(val real: Double, val imaginary: Double)

    val produce: (Double, Double) -> Complex = ::Complex

    // Function overloading and references
    fun foo(i: Int) = 1
    fun foo(str: String) = "AAA"
    val fooInt: (Int) -> Int = ::foo // 1
    val fooStr: (String) -> String = ::foo // AAA
    // Property references
    val getter: (Complex) -> Double = Complex::real

    //динамическая инициализация
    val d = 3.0
    val e = 4.0
    val f = sqrt(d * d + e * e) // f динамически инициализуется
    println("Гипотенуза равна $f")

    //еще способ присваивания - диапазон
    val mountains = (0 until 8)
    println("mountains = $mountains") //mountains = 0..7
}

class Person {

}

fun getCompanyName(): String {
    return "Мурзик"
}

fun returnNewNumber(number: Int): Int {
    return number
}

// какой-то класс
class MyClass {
    companion object {
        private const val FILE_EXTENSION = ".png"
        val FILENAME: String
            get() = "img_" + System.currentTimeMillis() + FILE_EXTENSION
    }
}

object PointX {
    var x = 0
} // объявление объекта

class TeamPoints(val points: List<Int>) {
    fun <T> calculatePoints(operation: (List<Int>) -> T): T =
        operation(points)
}
