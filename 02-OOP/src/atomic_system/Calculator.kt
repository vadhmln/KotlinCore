package atomic_system

fun main() {
    val calculator = Calculator()
    calculator.run()
}

class Calculator {
    private var operator: String = ""
    private var firstOperand: Double = 0.0
    private var secondOperand: Double = 0.0

    fun run() {
        initialize()
        input()
        val result = calculate()
        output(result)
    }

    private fun initialize() {
        println("Calculator initialized.")
    }

    private fun input() {
        println("Enter the operator (+, -, *, /): ")
        operator = readln()
        println("Enter the first operand: ")
        firstOperand = readln().toDouble()
        println("Enter the second operand: ")
        secondOperand = readln().toDouble()
    }

    private fun calculate(): Double {
        return when (operator) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "*" -> firstOperand * secondOperand
            "/" -> firstOperand / secondOperand
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }

    private fun output(result: Double) {
        println("Result: $result")
    }
}