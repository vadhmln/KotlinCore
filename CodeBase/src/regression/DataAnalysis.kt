package regression

// пример кода на Kotlin, который демонстрирует использование линейной регрессии для анализа данных:
fun main() {
    val data = arrayOf(
        doubleArrayOf(1.0, 2.0),
        doubleArrayOf(2.0, 3.0),
        doubleArrayOf(3.0, 4.0),
        doubleArrayOf(4.0, 5.0),
        doubleArrayOf(5.0, 6.0)
    )

    val regression = SimpleRegression()
    data.forEach { regression.addData(it[0], it[1]) }

    println("Intercept: ${regression.getIntercept()}")
    println("Slope: ${regression.getSlope()}")
    println("R-squared: ${regression.getRSquare()}")
}