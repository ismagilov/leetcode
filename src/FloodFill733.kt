import java.util.ArrayDeque

/**
 * https://leetcode.com/problems/flood-fill/
 */
class FloodFill733 {
    fun floodFillDfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val replaceColor = image[sr][sc]

        fun dfs(r: Int, c: Int) {
            if (r !in image.indices || c !in image[r].indices || image[r][c] == color || image[r][c] != replaceColor)
                return

            image[r][c] = color

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c - 1)
            dfs(r, c + 1)
        }

        dfs(sr, sc)

        return image
    }

    fun floodFillBfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val q = ArrayDeque<Pair<Int, Int>>()
        val replaceColor = image[sr][sc]

        fun getNeighbours(loc: Pair<Int, Int>) = listOf(
                Pair(loc.first - 1, loc.second),
                Pair(loc.first + 1, loc.second),
                Pair(loc.first, loc.second - 1),
                Pair(loc.first, loc.second + 1)
        )

        fun isValid(n: Pair<Int, Int>) = n.first in image.indices
                && n.second in image[n.first].indices
                && image[n.first][n.second] != color
                && image[n.first][n.second] == replaceColor

        val start = Pair(sr, sc)
        if (isValid(start))
            q.add(start)

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            image[cur.first][cur.second] = color
            getNeighbours(cur).filter { isValid(it) }.forEach { q.add(it) }
        }

        return image
    }
}

fun main() {
//    println(FloodFill733().floodFillDfs(arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1)), 1, 1, 2))
    printArray(FloodFill733().floodFillBfs(arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1)), 1, 1, 2))
    printArray(FloodFill733().floodFillBfs(arrayOf(intArrayOf(1,1,1), intArrayOf(1,2,0), intArrayOf(1,0,1)), 1, 1, 2))
}

fun printArray(arr: Array<IntArray>) {
    println('[')
    arr.forEach {
        println(it.joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }
    println(']')
}