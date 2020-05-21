class PerformStringShifts1427 {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var left = 0
        var right = 0

        for (sh in shift) {
            when(sh[0]) {
                0 -> left += sh[1]
                1 -> right += sh[1]
            }
        }

        val finalShift = (right - left) % s.length
        val delimiter = (s.length - finalShift) % s.length

        return s.substring(delimiter, s.length) + s.substring(0, delimiter)
    }
}

fun main() {
    println(PerformStringShifts1427().stringShift("abcdefg", arrayOf(intArrayOf(0, 7))))
    println(PerformStringShifts1427().stringShift("abcdefg", arrayOf(intArrayOf(0, 0))))
    println(PerformStringShifts1427().stringShift("abcdefg", arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(1, 3))))
}