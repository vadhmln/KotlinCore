import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {
    // companion object functions:
    // values - returns an array of all the values
    val directions = Direction.values()
    for (direction in directions) {
        println(direction) // NORTH SOUTH WEST EAST
    }

    // valueOf - для получения enum-константы по её имени
    val north = Direction.valueOf("NORTH")

    // top-level functions:
    // enumValues - returns an array of all the values
    val directionNext = enumValues<Direction>()
    for (direction in directionNext) {
        println(direction) // NORTH SOUTH WEST EAST
    }

    // enumValueOf - enum-константа по её имени
    val south = enumValueOf<Direction>("SOUTH")

    // enum-константа имеет поля:
    // имя и порядковый номер (c 0) в объявлении enum
    Direction.EAST.name
    Direction.EAST.ordinal

    //when для выбора правильного значения
    println(getMnemonic(MyColor.BLUE))
}

// для типобезопасных ограниченных значений
// Каждая enum-константа является объектом
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// экземпляры enum-класса могут быть инициализированы
// Enum-константы могут объявлять анонимные классы
// как с собственными методами, так и с перегруженными
// при объявлении каких-либо членов, отделять ;
enum class Color(val rgb: Int) {
    RED(0xFF0000) {
        fun myRed() {}
        override fun color(): Color = RED
    },
    GREEN(0x00FF00) {
        fun myGreen() {}
        override fun color(): Color = GREEN
    },
    BLUE(0x0000FF) {
        fun myBlue() {}
        override fun color(): Color = BLUE
    };

    abstract fun color(): Color
}

// Enum-класс может реализовывать интерфейс
// не наследоваться от класса
// единственная реализация членов интерфейса для всех констант
// либо отдельная для каждого элемента в своем анонимном классе
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int): Int = apply(t, u)
}

enum class MyColor {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//when для выбора правильного значения перечисления
fun getMnemonic(myColor: MyColor) {
    when (myColor) {
        MyColor.RED -> "Каждый"
        MyColor.ORANGE -> "Охотник"
        MyColor.YELLOW -> "Желает"
        MyColor.GREEN -> "Знает"
        MyColor.BLUE -> "Где"
        MyColor.INDIGO -> "Сидит"
        MyColor.VIOLET -> "Фазан"
    }
}