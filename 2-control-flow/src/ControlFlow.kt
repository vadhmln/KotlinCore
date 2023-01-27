package control_flow

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
    val max = if (a > b){
        println("возвращаем a")
        a
    }else{
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
}

fun takeInput(input: Any): Any {
    val result = when (input) {
        is String -> input.startsWith("Prefix")
        is Int -> input.toString()
        else -> {}
    }
    return result
}