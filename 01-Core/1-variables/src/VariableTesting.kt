fun main() {
//    val myNumber = 30
//    var string = "Text"
//    string = myNumber.toString()
//    println(myNumber::class)
//    println(string::class)
//    val c = 1
//    val d = 2
//    val a = (0..100)

    var number = 10

    number = number.apply {
        println("Initial value: $this")  // Доступ к самому объекту через this
        this + 5  // Присваиваем значение number, но apply возвращает исходный объект
    }

    println("After apply: $number")
}

