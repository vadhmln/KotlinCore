fun main() {
    //вызовы вложенной функции

    //именованные параметры
    println(max(a = 3, b = 5))

    //Нефиксированное число аргументов
    val list = asList(1, 2, 3)

    //оператор spread - позволяет передать параметру в качестве значения элементы из массива
    val a = arrayOf(4, 5, 6)
    val b = asList(1, *a)

    //преобразование в обычный (типизированный) массив
    val c = asList(*list.toTypedArray(), *a)
}

//Базовая структура функций
//fun max(a: Int, b: Int): Int {
//    return if (a > b) a else b
//}

//у функции тело состоит из единственного выражения
//fun max(a: Int, b: Int) = if (a > b) a else b

//Параметры функции могут иметь значения по умолчанию
//fun max(a: Int = 0, b: Int = 0) = if (a > b) a else b

/*
Если параметр по умолчанию предшествует параметру без значения по умолчанию,
значение по умолчанию можно использовать только при вызове функции с именованными аргументами
 */
fun max(a: Int = 0, b: Int) = if (a > b) a else b

//Переопределённые методы всегда используют те же самые значения по умолчанию, что и их базовые методы.
open class A {
    open fun foo(i: Int = 0) {} // Функции-члены
}

class B : A() {
    override fun foo(i: Int) {}
}

//Функции с возвращаемым типом Unit
fun printHi(name: String?): Unit {
    if (name != null)
        println("Hi $name")
    else
        println("Hi there!")
    //return Unit
}

//Нефиксированное число аргументов (Функции-обобщения)
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts - это массив (Array)
        result.add(t)
    return result
}

//Локальные функции
fun outer(aOuter: Int) {
    fun inner(aInner: Int) {
        if (aOuter > aInner) {
            aOuter
        } else aInner
    }
}

//Функции с хвостовой рекурсией
val eps = 1E-10
tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

//Листинг 3.1. Чистые и нечистые функции
class FunFunctions {
    var percent1 = 5
    fun applyTax1(a: Int): Int = a / 100 * (100 + percent1)
    private var percent2 = 9
    fun applyTax2(a: Int): Int = a / 100 * (100 + percent2)
    val percent3 = 13
    fun applyTax3(a: Int): Int = a / 100 * (100 + percent3)
    fun add(a: Int, b: Int): Int = a + b
    fun mult(a: Int, b: Int?): Int = 5
    fun div(a: Int, b: Int): Int = a / b
    fun div(a: Double, b: Double): Double = a / b
    fun append(i: Int, list: MutableList<Int>): List<Int> {
        list.add(i)
        return list
    }

    fun append2(i: Int, list: List<Int>) = list + i
}

fun applyTax1(ff: FunFunctions, a: Int): Int = a / 100 * (100 + ff.percent1)


//val length = "test".let {
//    println(it)
//    it.length
//}

val test = "test".also {
    println(it)
}

val moscow = City("Moscow").apply {
    this.population = 15_000_000
    println(this)
}

val optimalSquare = City("Moscow").run {
    this.population = 15_000_000
    this.solveOptimalSquare()
}

//val length = run {
//    val test = "test"
//    test.length
//}

val length = with("test") {
    this.length
}


data class City(val name: String = "", var population: Int = 0) {
    fun solveOptimalSquare() {
    }
}





