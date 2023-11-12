//interface EatableAndCatchable {
//    fun <T> eat(any: T): T = any
//    fun <T> catch(any: T): T = any
//}
//
//class Cat(private val age: Int, private val color: Int) : EatableAndCatchable {
//    override fun <T> eat(any: T): T = any
//    override fun <T> catch(any: T): T = any
//}
//
//class Robot(private val power:Int): EatableAndCatchable {
//    override fun <T> eat(any: T): T = any
//    override fun <T> catch(any: T): T = any
//}
//
//fun main() {
//    val cat = Cat(age = 2, color = 2)
//    val robot = Robot(power = 100)
//    cat.catch(robot)
//    robot.eat(cat)
//}

// Определяем интерфейс Eatable, который описывает объекты, которые могут быть съедены
interface Eatable {
    // Метод eat принимает и возвращает объект типа Eatable
    fun eat(other: NewEatable): NewEatable
}

// Определяем интерфейс Catchable, который описывает объекты, которые могут ловить
interface Catchable {
    // Метод catch принимает и возвращает объект типа Catchable
    fun catch(other: Catchable): Catchable
}

// Определяем класс Cat, который реализует интерфейсы Eatable и Catchable
class Cat(private val name: String, private val age: Int, private val color: Int) : NewEatable, Catchable {
    // Свойства hunger и energy отражают состояние кошки
    private var hunger = 10 // от 0 до 10, где 0 - очень голодный, а 10 - очень сытый
    private var energy = 10 // от 0 до 10, где 0 - очень усталый, а 10 - очень бодрый

    // Переопределяем метод eat так, чтобы он уменьшал голод и увеличивал энергию кошки, а также возвращал съеденный объект
    override fun eat(other: NewEatable): NewEatable {
        println("$name eats $other")
        hunger = minOf(hunger + 2, 10) // увеличиваем голод на 2, но не больше 10
        energy = minOf(energy + 1, 10) // увеличиваем энергию на 1, но не больше 10
        println("$name's hunger is $hunger and energy is $energy")
        return other // возвращаем съеденный объект
    }

    // Переопределяем метод catch так, чтобы он уменьшал энергию кошки и возвращал пойманный объект
    override fun catch(other: Catchable): Catchable {
        println("$name catches $other")
        energy = maxOf(energy - 2, 0) // уменьшаем энергию на 2, но не меньше 0
        println("$name's energy is $energy")
        return other // возвращаем пойманный объект
    }

    // Переопределяем метод toString, чтобы он возвращал имя и возраст кошки
    override fun toString(): String {
        return "Cat(name=$name, age=$age)"
    }
}

// Определяем класс Robot, который реализует интерфейс Catchable
class Robot(private val model: String, private val power: Int) : Catchable {
    // Свойство battery отражает заряд батареи робота
    private var battery = 100 // от 0 до 100, где 0 - разряжен, а 100 - заряжен

    // Переопределяем метод catch так, чтобы он уменьшал заряд батареи робота и возвращал пойманный объект
    override fun catch(other: Catchable): Catchable {
        println("$model catches $other")
        battery = maxOf(battery - 10, 0) // уменьшаем заряд на 10, но не меньше 0
        println("$model's battery is $battery")
        return other // возвращаем пойманный объект
    }

    // Переопределяем метод toString, чтобы он возвращал модель и мощность робота
    override fun toString(): String {
        return "Robot(model=$model, power=$power)"
    }
}

interface NewEatable {
    fun eat(other: NewEatable): NewEatable
}

class Dog : NewEatable {
    private var age = 0

    override fun eat(other: NewEatable): NewEatable {
        val dog = other as Dog
        age += dog.age
        return this
    }
}

fun calculate(a: Double, b: Double, operation: (Double, Double) -> Double): Double {
    return operation(a, b)
}

val add: (Double, Double) -> Double = { a, b -> a + b }
val subtract: (Double, Double) -> Double = { a, b -> a - b }
val multiply: (Double, Double) -> Double = { a, b -> a * b }
val divide: (Double, Double) -> Double = { a, b -> a / b }

// Функция main остается без изменений
fun main() {
    val cat = Cat(name = "Tom", age = 2, color = 2)
    val robot = Robot(model = "T-800", power = 100)
    cat.eat(cat)
    robot.catch(cat)

    println("Enter the first number:")
    val a = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input")
    println("Enter the second number:")
    val b = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input")
    println("Enter the operator (+, -, *, /):")
    val operator = readLine()?.firstOrNull() ?: throw IllegalArgumentException("Invalid input")

    val result2 = calculate(a, b, when (operator) {
        '+' -> add
        '-' -> subtract
        '*' -> multiply
        '/' -> divide
        else -> throw IllegalArgumentException("Invalid operator: $operator")
    })
    println("Result using FP style: $result2")
}