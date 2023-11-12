package regression

import kotlin.math.pow

/**
 * Этот класс реализует простую линейную регрессию на основе набора данных,
 * который можно добавлять с помощью метода addData.
 * Методы getIntercept, getSlope и getRSquare возвращают коэффициент пересечения,
 * наклон и коэффициент детерминации (R-квадрат) для полученной линейной модели.
 */
class SimpleRegression {
    private var sumX = 0.0
    private var sumY = 0.0
    private var sumXX = 0.0
    private var sumXY = 0.0
    private var n = 0

    fun addData(x: Double, y: Double) {
        sumX += x
        sumY += y
        sumXX += x * x
        sumXY += x * y
        n++
    }

    fun getIntercept(): Double {
        val denominator = n * sumXX - sumX * sumX
        return (sumY * sumXX - sumX * sumXY) / denominator
    }

    fun getSlope(): Double {
        val denominator = n * sumXX - sumX * sumX
        return (n * sumXY - sumX * sumY) / denominator
    }

    fun getRSquare(): Double {
        val meanY = sumY / n
        val ssTot = (1 until n).sumOf { i -> (getY(i) - meanY).pow(2.0) }
        val ssRes = (1 until n).sumOf { i -> (getY(i) - getPredictedY(i)).pow(2.0) }
        return 1 - ssRes / ssTot
    }

    private fun getY(i: Int): Double {
        return sumY / n
    }

    private fun getPredictedY(i: Int): Double {
        val slope = getSlope()
        val intercept = getIntercept()
        return slope * i + intercept
    }
}