@file:Suppress("UNREACHABLE_CODE")

package control_flow

import java.util.*
import kotlin.math.abs

fun main() {
    // Разные действия в зависимости от какого-либо условия

    val a = 7
    val b = 6
    //если if является выражением (значение можно присвоить переменной)
    //else является обязательным
    val c = if (a > b) a else b // тернарный
    println(c) // 7

    //присвоить значение какой-либо переменной в зависимости от условий
    val humanAge = 15
    val document = if (humanAge > 14) {
        "Паспорт"
    } else {
        "Свидетельство о рождении"
    }
    println(document) // Паспорт

    // обычное использование
    var maxRegular = a
    if (a < b) maxRegular = b

    // с блоком else
    var maxWithBlockElse: Int
    if (a > b) {
        maxWithBlockElse = a
    } else {
        maxWithBlockElse = b
    }

    // в виде выражения
    // замена тернарного оператора
    val maxExpression = if (a > b) a else b

    // Также заменяют тернарный оператор: оператор Elvis
    val user: User = User(null)
    val name = user.name ?: ""
    // и расширение orEmpty
    val nameExt = user.name.orEmpty()

    //выражения if могут содержать несколько строк кода, при этом последнее выражение является значением блока
    val max = if (a > b) {
        println("возвращаем a")
        a
    } else {
        println("возвращаем b")
        b
    }

    // when последовательно сравнивает свой аргумент со всеми указанными значениями,
    // пока не выполнится какое-либо из условий ветвей
    val z = 2
    when (z) {
        1 -> print("z == 1")
        2 -> print("z == 2")
        else -> { // обратите внимание на блок
            print("z не равен ни 1, ни 2")
        }
    }

    // для нескольких значений выполняется одно и то же действие
    when (z) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
    val s: Short = 10

    // Помимо констант в ветках можно использовать произвольные выражения
    when (z) {
        s.toInt() -> print("s encodes x")
        else -> print("s does not encode x")
    }

    // можно проверять вхождение аргумента в интервал in или !in
    val validNumbers = 1..10
    when (z) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    // с помощью is или !is проверить тип аргумента
    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    // Можно получать переменную внутри when условия
    fun Request.getBody() =
        when (val response = executeRequest()) {
            is Request.Success -> response.body
            is Request.HttpError -> throw HttpException(response.status)
            else -> {}
        }

//    val numericValue = when (getRandomBit()) {
//        Bit.ZERO -> 0
//        Bit.ONE -> 1
//        // 'else' не требуется, потому что все случаи учтены
//    }

    // Сложные проверки условий
    val rating = 5
    when {
        rating == 1 || rating == 2 -> println("Плохо")
        rating == 3 -> println("Нормально")
        rating == 4 -> println("Хорошо")
        rating == 5 -> println("Отлично")
    }

    fun printNumberSignNested(num: Int) {
        if (num < 0) {
            "negative"
        } else {
            if (num > 0) {
                "positive"
            } else {
                "zero"
            }.print()
        }
    }

    // Вместо вложенных условий - when
    fun printNumberSign(num: Int) {
        when {
            num < 0 -> "negative"
            num > 0 -> "positive"
            else -> "zero"
        }.print()
    }

    // Логические операторы соединяют два или более связанных выражения в одно
    // или изменяют логику выражения в обратном порядке
    val myTrue: Boolean = true
    val myFalse: Boolean = false
    var myBoolean = false
    if (myTrue || myFalse) myBoolean = true else false // или
    if (myTrue && myFalse) myBoolean = true else false // и
    if (!myTrue) myBoolean = true else false // отрицание

    // inside a range - best && operator
    val x = 25
    if (x >= 20 && x <= 40) {
        println("$x is in range")
    }

    // outside a range - best || operator
    val y = 45
    if (y < 20 || y > 40) {
        println("$y is outside the range")
    }

    // Операторы сравнений
    // a > b	a.compareTo(b) > 0
    // a < b	a.compareTo(b) < 0
    // a >= b	a.compareTo(b) >= 0
    // a <= b	a.compareTo(b) <= 0

    // Все выражения можно проверять на логику
    var aTest = 3
    var bTest = 4
    val testNum = if (aTest + bTest <= 10) {
        aTest = 20
    } else {
        bTest = 40
    }

    // Цикл for для выполнения известного числа итераций
    // Обход начинается с 0 и заканчивается на 10, включая 10-ку
    for (index in 0..10) {
        // выполнится 11 раз
        println("index = $index") // c 0->10
    }

    // чтобы 10-ку не включать, необходимо использовать ключевое слово until
    for (index in 0 until 10) {
        // выполнится 10 раз
        println("index = $index") // c 0->9
    }

    // Если необходимо сделать обход в обратном направлении, то использовать downTo
    for (index in 10 downTo 0) {
        // выполнение в обратную сторону
        println("index = $index") // включая 10->0
    }

    // Ко всем видам обхода можно применить step
    // Обход будет через заданное количество индексов
    for (index in 0 until 10 step 2) {
        // выполнится 5 раз (через каждые 2)
        println("index = $index") // 0,2,4,6,8
    }

    // for обеспечивает перебор всех значений, поставляемых итератором
    val collection = listOf("Tom", "Ben", "Ted")
    for (item in collection) print(item)

    // необходим порядковый номер элемента
    val array = arrayOf(1, 2, 3)
    for (i in array.indices) {
        println(array[i])
    }

    // использовать библиотечную функцию withIndex
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }


    // break - завершает ближайший замыкающий цикл
    for (i in 1..5) {
        if (i == 3) break
        println(i) // 1 2
    }

    // continue - переходит к следующему шагу ближайшего замыкающего цикла
    for (i in 1..5) {
        if (i == 3) continue
        println(i) // 1245
    }

    // iterate over elements with indices
    val names = listOf("Alex", "Bob", "Celina")
    for (i in 0 until names.size) {
        val name = names[i]
        println("[$i] $name") // [0] Alex [1] Bob [2] Celina
    }

    // Range could be replaced with '.indices'
    for (i in names.indices) {
        val name = names[i]
        println("[$i] $name")
    } // [0] Alex [1] Bob [2] Celina

    // iterate over indexed values
    for ((i, name) in names.withIndex()) {
        println("[$i] $name")
    } // [0] Alex [1] Bob [2] Celina

    // use forEachIndexed
    names.forEachIndexed { i, name ->
        println("[$i] $name")
    } // [0] Alex [1] Bob [2] Celina

    // iterating over a map
    val map = mapOf(1 to "A", 2 to "B")
    for (entry in map.entries) {
        println("${entry.key} ${entry.value}")
    }

    // directly iterating over a map,
    // calling entries is unnecessary
    for ((key, value ) in map) {
        println("$key $value")
    }

    // use forEach for a map
    map.forEach { (key, value) ->
        println("$key $value")
    }

    // while проверяет условие и, если оно истинно, выполняет тело
    var i = 1
    while (i <= 10) {
        i++
    }

    // do-while выполняет тело и только затем проверяет условие
    do {
        i++
    } while (i <= 10)

    // исключение явным образом - оператор throw
    throw Exception("Hi There!")

    // перехватить исключение - выражение try...catch
    val exception = try {
        // some code
    } catch (e: SomeException) {
        // handler
    } finally {
        // optional finally block
    }

}

class SomeException: Throwable() {

}

class HttpException(status: Any) : Throwable() {

}

fun getRandomBit(): Any {
    TODO("Not yet implemented")
}

fun takeInput(input: Any): Any {
    val result = when (input) {
        is String -> input.startsWith("Prefix")
        is Int -> input.toString()
        else -> {}
    }
    return result
}

fun closestToZero(ts: DoubleArray): Double {
    if (ts.isEmpty()) return 0.0
    var closest = ts[0]
    for (i in ts) {
        val abs = abs(i)
        val absClosest = abs(closest)
        if (abs < absClosest) {
            closest = i
        } else if (abs == absClosest && closest < 0) {
            closest = i
        }
    }
    return closest

//    val input = Scanner(System.`in`)
//    val lightX = input.nextInt() // the X position of the light of power
//    val lightY = input.nextInt() // the Y position of the light of power
//    var initialTx = input.nextInt() // Thor's starting X position
//    var initialTy = input.nextInt() // Thor's starting Y position

//    println(if (min != Int.MAX_VALUE) min else 0)
}

data class User(val name: String?)

// Function we can execute on any object, to print it
// 10.print() prints 10
// "ABC".print() prints ABC
fun Any?.print() {
    print(this)
}

enum class Bit {
    ZERO, ONE
}

sealed class Request {
    fun getBody() {}
    fun executeRequest(): Any {
        TODO("Not yet implemented")
    }

    object Success : Request() {
        val body: Any = TODO()
    }

    object HttpError : Request() {
        val status: Any = TODO()
    }
}


