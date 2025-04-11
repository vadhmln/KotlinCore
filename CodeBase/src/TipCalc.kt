import kotlin.math.roundToInt
import kotlin.math.roundToLong

/*
Create a simple tip calculator. The program should prompt
for a bill amount and a tip rate. The program must compute
the tip and then display both the tip and the total amount of
the bill.

- bill amount
- tip rate
- total amount
- tip

- prompt
- compute
- display
 */

fun main() {
    // prompt
    println("Введите сумму чека")
    val billAmount = readln().toDouble()

    println("Введите ставку чаевых")
    val tipRate = readln().toDouble()

    val tip = billAmount * (tipRate / 100)

    val totalAmount = billAmount + tip

    val roundedTotalAmount = (totalAmount * 100).roundToInt() / 100.0

    println("Tip = $tip \nВсего = $roundedTotalAmount")
}








