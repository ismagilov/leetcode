/**
 * https://leetcode.com/problems/flood-fill/
 */
class FloodFill733 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val replaceColor = image[sr][sc]

        tailrec fun dfs(r: Int, c: Int) {
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
}

fun main() {
    println(FloodFill733().floodFill(arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1)), 1, 1, 2))
}