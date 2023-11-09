import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    print("Введите два числа: ")
    val first = reader.nextDouble()
    val second = reader.nextDouble()

    print("Введите оператор (+, -, *, /): ")
    val operator = reader.next()[0]

    val result: Double = when (operator) {
        '+' -> first + second
        '-' -> first - second
        '*' -> first * second
        '/' -> first / second
        else -> {
            System.out.printf("Ошибка! Оператор не верен")
            return
        }
    }

    System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result)
}