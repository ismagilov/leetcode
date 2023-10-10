class FirstBadVersion278 {
    fun firstBadVersion(n: Int) : Int {
        var b = 0L
        var e = n + 1L
        while (b + 1 < e) {
            val mid = b + (e - b) / 2L

            when (isBadVersion(mid.toInt())) {
                true -> e = mid
                false -> b = mid
            }
        }

        return e.toInt()
    }

    private fun isBadVersion(version: Int): Boolean {
        return version > 2147483600
    }
}

fun main() {
    val s = FirstBadVersion278()

    println(s.firstBadVersion(11))
    println(s.firstBadVersion(Int.MAX_VALUE))
}