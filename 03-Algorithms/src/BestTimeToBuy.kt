fun main() {
    val prices = intArrayOf(2,1,2,0,1)

    // каждую цифру сравнить с остальными
    // найти большую цифру и вычесть из нее текущую

    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (price in prices) {
            if (price < minPrice) {
                minPrice = price
            } else {
                maxProfit = maxOf(maxProfit, price - minPrice)
            }
        }

        return maxProfit
    }

    println(maxProfit(prices))
}