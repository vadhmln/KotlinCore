fun main() {
    val prices = intArrayOf(3,3,5,0,0,3,1,4)

    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1]
            }
            println("цикл - $i prices i = ${prices[i]}, prices i - 1 = ${prices[i - 1]}, profit = $profit")
        }
        return profit
    }

    println(maxProfit(prices))
}