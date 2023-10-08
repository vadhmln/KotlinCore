package saferprograms

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

fun main(args: Array<String>) {
//    val x = add(mult(2, 3), mult(4, 5))
    val x = add(6, 20)
    println(x)


}

fun add(a: Int, b: Int): Int {
    log(String.format("Returning ${a + b} as the result of $a + $b"))
    return a + b
}

fun mult(a: Int, b: Int) = a * b

fun log(m: String) {
    println(m)
}

//Программа на Kotlin с побочными эффектами
//fun buyDonut(creditCard: CreditCard): Donut {
//    val donut = Donut()
//    creditCard.charge(donut.price) // ① Взимает плату с кредитной карты – это побочный эффект
//    return donut // ② Возвращает пончик
//}

//заменить побочные эффекты возвратом представления этих эффектов
//fun buyDonut(creditCard: CreditCard): Purchase {
//    val donut = Donut()
//    val payment = Payment(creditCard, Donut.price)
//    return Purchase(donut, payment)
//}

//можно сократить
//fun buyDonut(creditCard: CreditCard) = Purchase(Donut(), Payment(creditCard, Donut.price))

//листинг 1.4
fun buyDonuts(quantity: Int = 1, creditCard: CreditCard): Purchase =
    Purchase(List(quantity) { Donut() }, Payment(creditCard, Donut.price * quantity))

class CreditCard {
    // total has a public getter (by default) and a private setter
    var total: Double = 0.0
        private set

    fun charge(price: Double) {
        this.total += price
    }
}

class Donut {
    companion object {
        val price: Double = 0.0
    }
}

//листинг 1.3
//class Payment(val creditCard: CreditCard, val amount: Double) {
//
//    fun combine(payment: Payment): Payment =
//        if (creditCard == payment.creditCard)
//            Payment(creditCard, amount + payment.amount)
//        else
//            throw IllegalStateException("Cards don't match.")
//}

//функция buyDonut должна возвращать Donut и Payment, с этой целью
//можно создать отдельный класс
data class Purchase(val donuts: List<Donut>, val payment: Payment)

class DonutShopKtTest {
    @Test
    fun testBuyDonuts() {
        val creditCard = CreditCard()
        val purchase = buyDonuts(5, creditCard)
        assertEquals(Donut.price * 5, purchase.payment.amount)
        assertEquals(creditCard, purchase.payment.creditCard)
    }
}

//Листинг 1.5. Группировка платежей кредитной картой
data class Payment(val creditCard: CreditCard, val amount: Double) {
    fun combine(payment: Payment): Payment =
        if (creditCard == payment.creditCard)
            Payment(creditCard, amount + payment.amount)
        else
            throw IllegalStateException("Cards don't match.")

    companion object {
        fun groupByCard(payments: List<Payment>): List<Payment> =
            payments.groupBy { it.creditCard } // ①
                .values // ②
                .map { it.reduce(Payment::combine) } // ③
    }

    fun combine(payment1: Payment, payment2: Payment): Payment =
        if (payment1.creditCard == payment2.creditCard)
            Payment(payment1.creditCard, payment1.amount + payment2.amount)
        else
            throw IllegalStateException("Cards don't match.")

    val doubleThenIncrement: (Int) -> Int = { x ->
        val double = x * 2
        double + 1
    }
}

sealed class SealedClass {
    class One(val value: Int) : SealedClass()
    class Two(val x: Int, val y: Int) : SealedClass()

    fun eval(e: SealedClass): Int =

        when (e) {

            is One -> e.value

            is Two -> e.x + e.y
        }
}

class Something {

    companion object {
        val age = 11

        fun bar() {
            println("Companion object called")
        }
    }
}

suspend fun main() = coroutineScope{

    launch {
        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")
    }
    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
}





