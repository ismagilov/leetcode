class CountingBits338 {
    /*
    10: 1010
    20: 10100

    0: 0
    1: 1
     */
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)

        for (v in 0..n) {
            ans[v] = ans[v / 2] + v % 2
        }

        return ans
    }
}

fun main() {
    val s = CountingBits338()
    println(s.countBits(20).joinToString(" "))
}