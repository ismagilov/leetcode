class RomanToInteger13 {
    fun romanToInt(s: String): Int {
        return s.mapIndexed { i, r ->
            when (r) {
                'I' -> if ((s.getOrNull(i + 1) ?: ' ') in charArrayOf('V', 'X')) -1 else 1
                'V' -> 5
                'X' -> if ((s.getOrNull(i + 1) ?: ' ') in charArrayOf('L', 'C')) -10 else 10
                'L' -> 50
                'C' -> if ((s.getOrNull(i + 1) ?: ' ') in charArrayOf('D', 'M')) -100 else 100
                'D' -> 500
                'M' -> 1000
                else -> throw IllegalStateException()
            }
        }.sum()
    }
}

fun main() {
    val s = RomanToInteger13()

    println(s.romanToInt("MCMXCIV"))
    println(s.romanToInt("LVIII"))
    println(s.romanToInt("IV"))
}