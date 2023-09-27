class NumberOf1Bits {
    // you need to treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var value = n
        var cnt = 0
        for (i in 0..31) {
            cnt += value and 1
            value = value ushr 1
        }
        return cnt
    }

    fun hammingWeightB(n: Int): Int {
        var cnt = 0
        var mask = 1
        // 0000
        for (i in 0..31) {
            if (n and mask != 0)
                cnt++

            mask = mask shl 1
        }

        return cnt
    }
}

fun main() {
    val s = NumberOf1Bits()

    println(s.hammingWeightB(1))
    println(s.hammingWeightB(3))
    println(s.hammingWeightB(4))
    println(s.hammingWeightB(-1))
    println(s.hammingWeightB(-3))
}
