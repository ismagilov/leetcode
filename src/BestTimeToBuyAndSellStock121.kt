class BestTimeToBuyAndSellStock121 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (p in prices) {
            if (p < minPrice)
                minPrice = p
            else if (maxProfit < p - minPrice)
                maxProfit = p - minPrice
        }

        return maxProfit
    }
}

fun main() {
    val s = BestTimeToBuyAndSellStock121();

    println(s.maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(s.maxProfit(intArrayOf(7,6,4,3,1)))
}