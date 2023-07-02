package control_flow

import java.util.*
import kotlin.math.abs

fun main() {
    val a = 7
    val b = 6
    //if является выражением (значение можно присвоить переменной)
    //использование ветки else является обязательным
    val c = if (a > b) a else b // тернарный а > b ? а : b в Java
    println(c) // 7

    //присвоить значение какой-либо переменной в зависимости от условий
    val humanAge = 15
    val document = if (humanAge > 14)
        "Паспорт"
    else
        "Свидетельство о рождении"
    println(document) // Паспорт

    //выражения if могут содержать несколько строк кода, при этом последнее выражение является значением блока
    val max = if (a > b) {
        println("возвращаем a")
        a
    } else {
        println("возвращаем b")
        b
    }

    //Сложные проверки условий - when
    val rating = 5
    when {
        rating == 1 || rating == 2 -> println("Плохо")
        rating == 3 -> println("Нормально")
        rating == 4 -> println("Хорошо")
        rating == 5 -> println("Отлично")
    }

    // Цикл For
    for (index in 0..10) { // Обход начинается с 0 и заканчивается на 10, включая 10-ку.
        // выполнится 11 раз
        println("index = $index")
    }

    // чтобы 10-ку не включать, необходимо использовать ключевое слово until
    for (index in 0 until 10) {
        // выполнится 10 раз
        println("index = $index")
    }

    // Если необходимо сделать обход в обратном направлении, то использовать downTo
    for (index in 10 downTo 0) {
        // выполнение в обратную сторону
        println("index = $index")
    }

    // Ко всем видам обхода можно применить step. Обход будет через заданное количество индексов
    for (index in 0 until 10 step 2) {
        // выполнится 5 раз (через каждые 2)
        println("index = $index")
    }

    // пример
    val arrayText1 = arrayOf("Test", "the", "code")

    for (index in 0 until arrayText1.size) {
        println("index = $index, value = ${arrayText1[index]}")
    }

    // еще более удобный вариант:
    val arrayText = arrayOf("Test", "the", "code")

    for (value in arrayText) {
        // распечатает значение каждой ячейки в массиве
        println("value = $value")
    }

    for (index in arrayText.indices) {
        // получаем индексы
        println("index = $index, value = ${arrayText[index]}")
    }

    for ((index, value) in arrayText.withIndex()) {
        // а вот тут, получаем и индексы и значение
        print("index = $index, value = $value ")
    }

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

//    println(if (min != Int.MAX_VALUE) min else 0)
}



