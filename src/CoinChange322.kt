import java.lang.Integer.min

class CoinChange322 {
    fun coinChangeTopToBottom(coins: IntArray, amount: Int): Int {
        return coinChangeTopToBottom(coins, amount, IntArray(amount + 1))
    }

    private fun coinChangeTopToBottom(coins: IntArray, reminder: Int, count: IntArray): Int {
        if (reminder == 0) return 0
        if (reminder < 0) return -1

        var min = Int.MAX_VALUE
        for (coin in coins) {
            val numberOfCoins = coinChangeTopToBottom(coins, reminder - coin, count)
            if (numberOfCoins != -1) {
                min = min(min, numberOfCoins + 1)
            }
        }
        count[reminder] = if (min == Int.MAX_VALUE) -1 else min

        return count[reminder]
    }

    /*

    F(3) = min(F(3-2), F(3-3), F(3-5))

    amnt/coins
       2  3  5
    1  -  -  -
    2  1  -  -
    3  -  1  -
    4  2  -  -
    5  2  2  1
    6  3  2  -
     */
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0

        for (amnt in 1..amount) {
            for (coin in coins) {
                if (amnt - coin >= 0 && dp[amnt - coin] != Int.MAX_VALUE) {
                    dp[amnt] = min(dp[amnt], dp[amnt - coin] + 1)
                }
            }
        }

        return when (dp[amount] == Int.MAX_VALUE) {
            true -> -1
            false -> dp[amount]
        }
    }
}

fun main() {
    val s = CoinChange322()

//    println(s.coinChangeTopToBottom(intArrayOf(4,7), 8))
//    println(s.coinChangeTopToBottom(intArrayOf(4,7), 2))
//    println(s.coinChangeTopToBottom(intArrayOf(2,3,5), 6))
//    println(s.coinChangeTopToBottom(intArrayOf(1,2,5), 11))
    /*

    F(3) = min(F(3-2), F(3-3), F(3-5))

    amnt/coins
       2
    1  -
    2  1
    3  -
     */
    println(s.coinChange(intArrayOf(2), 3))
}