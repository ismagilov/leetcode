/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeToBuyAndSellStockII122 {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1]
        }

        return profit
    }
}

fun main() {
    println(BestTimeToBuyAndSellStockII122().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(BestTimeToBuyAndSellStockII122().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}