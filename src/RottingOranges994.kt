class RottingOranges994 {

//    0 representing an empty cell,
//    1 representing a fresh orange, or
//    2 representing a rotten orange.
    fun orangesRotting(grid: Array<IntArray>): Int {
        var fresh = 0
        var timer = -1 // Initial rotten oranges in a queue do not add up a second
        val delimeter = Point(Int.MIN_VALUE, Int.MIN_VALUE)

        val q = ArrayDeque<Point>()
        for (r in 0 until grid.size) {
            for (c in 0 until grid[0].size) {
                when (grid[r][c]) {
                    Type.FRESH.value -> fresh++
                    Type.ROTTEN.value -> q.addLast(Point(r, c))
                }
            }
        }

        q.addLast(delimeter)

        while (q.isNotEmpty()) {
            val first = q.removeFirst()

            if (first == delimeter) {
                timer++
                if (q.isNotEmpty())
                    q.addLast(delimeter)

                continue
            }

            first.neighbours()
                .filter { (r, c) -> 0 <= r && r < grid.size && 0 <= c && c < grid[0].size  }
                .filter { (r, c) -> grid[r][c] == Type.FRESH.value }
                .forEach {
                    fresh--
                    grid[it.r][it.c] = Type.ROTTEN.value
                    q.addLast(it)
                }

        }

        return when (fresh) {
            0 -> timer
            else -> -1
        }
    }

    enum class Type(val value: Int) {
        EMPTY(0),
        FRESH(1),
        ROTTEN(2)
    }

    data class Point(val r: Int, val c: Int) {
        fun neighbours(): List<Point> {
            return listOf(
                Point(r - 1, c),
                Point(r + 1, c),
                Point(r, c - 1),
                Point(r, c + 1),
            )
        }
    }
}

fun main() {
    val s = RottingOranges994()

//    println(s.orangesRotting(arrayOf(intArrayOf(2,1,1),intArrayOf(1,1,0),intArrayOf(0,1,1))))
    println(s.orangesRotting(arrayOf(intArrayOf(2,1),intArrayOf(1,0))))
}