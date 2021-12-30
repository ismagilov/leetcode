import kotlin.math.min

/**
 * https://leetcode.com/problems/paint-house/
 */
class PaintHouse256 {
    fun minCost(costs: Array<IntArray>): Int {
        if (costs.isEmpty())
            return 0

        var prevRow = costs.last()

        for (i in costs.size - 2 downTo 0) {
            val curRow = costs[i].copyOf()

            curRow[0] = curRow[0] + min(prevRow[1], prevRow[2])
            curRow[1] = curRow[1] + min(prevRow[0], prevRow[2])
            curRow[2] = curRow[2] + min(prevRow[0], prevRow[1])

            prevRow = curRow
        }

        return prevRow.min() ?: 0
    }
}

fun main() {
    val ps = PaintHouse256()

    println(ps.minCost(arrayOf(intArrayOf(17, 2, 17), intArrayOf(16, 16, 5), intArrayOf(14, 3, 19))))
}