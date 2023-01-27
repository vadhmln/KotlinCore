import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {
    /*
    методы для вывода списка объявленных enum-констант и
    для получения enum-константы по её имени
     */
    Direction.valueOf("NORTH")

    /*
    Каждая enum-константа имеет поля, в которых содержатся её имя и
    порядковый номер в объявлении enum-класса
     */
    Direction.EAST.name
    Direction.EAST.ordinal

    //when для выбора правильного значения перечисления
    println(getMnemonic(Color.BLUE))
}

/*
реализация типобезопасных перечислений
Каждая enum-константа является объектом
 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

/*
Enum-константы также могут объявлять свои собственные анонимные классы
как с их собственными методами, так и с перегруженными методами базового класса
при объявлении в enum-классе каких-либо членов, необходимо отделять их от объявления констант точкой с запятой
 */
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/*
Enum-класс может реализовывать интерфейс (но не наследоваться от класса), предоставляя либо
единственную реализацию членов интерфейса для всех элементов enum, либо отдельные для каждого
элемента в своем анонимном классе. Это достигается путем добавления интерфейсов, которые вы хотите реализовать,
к объявлению класса enum
 */

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int): Int = apply(t, u)
}

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//when для выбора правильного значения перечисления
fun getMnemonic(color: Color) {
    when (color) {
        Color.RED -> "Каждый"
        Color.ORANGE -> "Охотник"
        Color.YELLOW -> "Желает"
        Color.GREEN -> "Знает"
        Color.BLUE -> "Где"
        Color.INDIGO -> "Сидит"
        Color.VIOLET -> "Фазан"
    }
}