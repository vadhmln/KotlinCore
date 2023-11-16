package atomic_system

interface Listener {
    fun onResult(result: Double)
}

interface Operator {
    fun execute(a: Double, b: Double): Double
}

class AddOperator : Operator {
    override fun execute(a: Double, b: Double): Double = a + b
}

class SubtractOperator : Operator {
    override fun execute(a: Double, b: Double): Double = a - b
}

class MultiplyOperator : Operator {
    override fun execute(a: Double, b: Double): Double = a * b
}

class DivideOperator : Operator {
    override fun execute(a: Double, b: Double): Double = a / b
}

class Calculator {
    private val listeners = mutableListOf<Listener>()

    fun addListener(listener: Listener) {
        listeners.add(listener)
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    fun calculate(a: Double, b: Double, operator: Operator) {
        val result = operator.execute(a, b)
        listeners.forEach { it.onResult(result) }
    }
}

fun main() {
    val calculator = Calculator()
    val listener = object : Listener {
        override fun onResult(result: Double) {
            println("Result: $result")
        }
    }
    calculator.addListener(listener)
    calculator.calculate(2.0, 3.0, AddOperator())
    calculator.calculate(5.0, 2.0, SubtractOperator())
    calculator.removeListener(listener)
}