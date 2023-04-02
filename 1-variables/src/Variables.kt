import kotlin.math.sqrt

// объявлять глобальные переменные за пределами блока класса
val PI = 3.14

const val catName = "Мурзик" // можно
val catNameNext = "Мурзик" // тоже можно

//const val catNameSecond = getCompanyName() // нельзя, нужно сразу присвоить значение без вычислений
val catNameSecondNext = getCompanyName() // а так можно

class Test {
    val x = PI
}

fun main() {

    val test = 9
    //тип можно указать (или не указывать) после имени переменной
    val intA = 25
    val intB: Int = 25

    //Если в объявлении переменной отсутствует инициализирующее выражение, ее тип нужно указать явно
    val name: String
    name = "Tom"

    /*
     * Неизменяемые (только для чтения) локальные переменные определяются с помощью ключевого слова
     * val (от value) - неизменяемая ссылка. Таким переменным нельзя присвоить значение после инициализации.
     * Неизменяемые переменные - соответствуют финальным (final) переменным в Java
     */

    val a = 1

    /*
     * Переменная, объявленная с ключевым словом val, должна быть инициализирована только один раз
     * во время выполнения блока, в котором она определена.
     * Инициализировать разными значениями в зависимости от некоторых условии,
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
     *несмотря на невозможность изменить ссылку val, объект, на который она указывает, может быть изменяемым
     */
    val languages = arrayListOf("Java") //Объявпение неизменяемой ссылки
    languages.add("Kotlin")                           //Изменение объекта, на который она указывает

    //var позволяет менять значение переменной, но её тип фиксирован
//    var number = 30
//    number = "Text" //type mismatch

//    println(number)

    /*Если нужно сохранить в переменной значение другого типа,
     *необходимо преобразовать его вручную или привести к нужному типу.
     */

    val long = 3.14
    var int = 0
    int = long.toInt()

    println("$long")
    //Способы присваивания значения переменным:

    //добавление литерала после знака равенства
    val x = 12

    //присвоить значение одной переменной другой
//    val a = 10
//    var b = a

    //использовать выражение
//    val c = a + b

    //метод с соответствующим возвращаемым типом
    val number = returnNewNumber(10)

    //лямбда выражение
    val sumNumbers = { a: Int, b: Int -> a + b }

    //динамическая инициализация
    val d = 3.0
    val e = 4.0
    val f = sqrt(d * d + e * e) // f динамически инициализуется
    println("Гипотенуза равна $f")
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
