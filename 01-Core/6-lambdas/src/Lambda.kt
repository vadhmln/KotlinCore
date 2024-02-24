package lambda

import java.util.*
import javax.swing.text.View

fun main() {
    // Лямбда-выражения и анонимные функции – это "функциональный литерал",
    // необъявленная функция, немедленно используется в качестве выражения.
    // Лямбда-выражения определяются в фигурных скобках {...}.
    // даже просто пустые фигурные скобки определяют лямбда
    // объявление параметров внутри этих скобок
    // тело функции начинается после знака ->
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val f: () -> Unit = {}
    f(); // or f.invoke()
    // вынесите все необязательные объявления
    val sumClean = { x: Int, y: Int -> x + y }

    // все фигурные скобки, не часть языковых структур,
    // являются лямбда-выражениями
    { println("AAA") } // never invoked
    fun produce() = { 42 }
    println(produce()) // () -> kotlin.Int

    // we should either call the produced function
    fun produceFun() = { 42 }
    val fn = produceFun()
    println(fn()) // 42
    println(produceFun()()) // 42
    println(produceFun().invoke()) // 42
    // or remove the braces
    fun produceNum() = 42
    println(produceNum()) // 42

    // separate the content of the braces with an arrow ->
    val printTimes = { text: String, times: Int ->
        for (i in 1..times) {
            print(text)
        }
    } // the type is (text: String, times: Int) -> Unit
    printTimes("Na", 7) // NaNaNaNaNaNaNa
    printTimes.invoke("Batman", 2) // BatmanBatman

    // define lambda expressions as arguments of functions
//    fun setOnClickListener(listener: (View, Click) -> Unit) {}
//    setOnClickListener { view, click ->
//        println("Clicked")
//    }

    // to ignore a parameter, we can use underscore (_)
//    setOnClickListener { _, _ ->
//        println("Clicked")
//    }

    // use destructuring when defining a lambda expression’s parameters
    data class User(val name: String, val surname: String)
    data class Element(val id: Int, val type: String)
    fun setOnClickListener(listener: (User, Element) -> Unit) {}
    setOnClickListener { (name, surname), (id, type) ->
        println(
            "User $name $surname clicked " +
                    "element $id of type $type"
        )
    }

    // it: неявное имя единственного параметра
    val ints = listOf(1, 2, 3, 4, 5)
    // этот литерал имеет тип '(it: Int) -> Boolean'
    ints.filter { it > 0 }

    // last parameter - functional type, define a lambda
    // expression outside the parentheses - trailing lambda
    fun <R> run(block: () -> R): R = block()
    fun repeat(times: Int, block: (Int) -> Unit) {
        for (i in 0 until times) {
            block(i)
        }
    }
    run { println("A") } // A
    repeat(2) { print("B") } // BB

    run() { println("A") } // A
    println()
    repeat(2) { print("B") } // BB

    // вместо return, возвращается
    // результат последнего оператора
    val fnn = { 10; 20; 30 }
    println(fnn()) // 30

    // To use return in the middle of a lambda,
    // use a label before a lambda expression
    // with the label name followed by @
    onUserChanged someLabel@{ user ->
        if (user == null) return@someLabel
        cheerUser(user)
    }

    // if a lambda is used as an argument to a function,
    // the name of this function becomes its default label
    onUserChanged { user ->
        if (user == null) return@onUserChanged
        cheerUser(user)
    }

    // код в стиле LINQ
    val strings = listOf("abcdefg")
    strings.filter { it.length == 5 }.sortedBy { it }.map { it.uppercase() }

    // lambda can use and modify variables from the
    // scope where it is defined - closure
    fun makeCounter(): () -> Int {
        var i = 0
        return { i++ }
    }
    val counter1 = makeCounter()
    val counter2 = makeCounter()
    println(counter1()) // 0
    println(counter1()) // 1
    println(counter2()) // 0
    println(counter1()) // 2
    println(counter1()) // 3
    println(counter2()) // 1

    // примеры
    val capitalize = { str: String -> str.capitalize() }
    fun transform(str:String, fn: (String) -> String): String {
        return fn(str)
    }
    // we can generalize transform
    fun <T> transform(t: T, fn: (T) -> T): T {
        return fn(t)
    }
    // pass capitalize as a parameter directly
    println(transform("kotlin", capitalize)) // Kotlin
    val reverse = {str: String -> str.reversed()}
    println(transform("kotlin", reverse)) // niltok
    println(transform("kotlin") { it.substring(0..1) }) // ko


//    val sum = { x: Int, y: Int ->
//        println("Computing the sum of $x and $y ...")
//        x + y// результат - последнее выражение
//    }
//    println(sum(1, 2)) // 3

    //лямбда-выражение можно вызывать напрямую
//    val sum1 = { println(42) } // 42

    //фрагмент кода в блок run
//    run { println(42) }

    // remove dots from a string:
    fun isNotDot(c: Char): Boolean = c != '.'
    val originalText = "I don't know... what to say..."
    val textWithoutDots = originalText.filter(::isNotDot)

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

class Click

data class Person(val name: String, val age: Int)
data class User(val name: String, val surname: String)

fun cheerUser(user: Any) {
    TODO("Not yet implemented")
}

fun onUserChanged(user: (Any) -> Unit) {
    TODO("Not yet implemented")
}




