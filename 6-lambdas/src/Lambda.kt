package lambda

fun main() {
    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y ...")
        x + y// результат - последнее выражение
    }
    println(sum(1, 2)) // 3

    //лямбда-выражение можно вызывать напрямую
//    val sum1 = { println(42) } // 42

    //фрагмент кода в блок run
//    run { println(42) }

    val people = listOf<Person>(Person("Bob", 34), Person("Anna", 45))

    //maxBy без сокращений
    people.maxBy({ p: Person -> p.age })

    //вынести лямбда-выражение за круглые скобки
    people.maxBy() { p: Person -> p.age }

    //избавиться от пустых круглых скобок функции
    people.maxBy { p: Person -> p.age }

    //избавляемся от типа параметра
    people.maxBy { p -> p.age }

    //неявное имя единственного параметра
    people.maxBy { it.age }

    //лямбда-выражение хранится в переменной
    val getAge = { p: Person -> p.age }
    people.maxBy(getAge)
}

data class Person(val name: String, val age: Int)




