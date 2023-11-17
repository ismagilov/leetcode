class NumberofIslands200 {
    fun numIslandsA(grid: Array<CharArray>): Int {
        var islands = 0
        val rows = grid.size
        val cols = grid[0].size

        fun dfs(i: Int, j: Int) {
            if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0')
                return

            grid[i][j] = '0'
            for ((dx, dy) in listOf((1 to 0), (-1 to 0), (0 to 1), (0 to -1))) {
                dfs(i + dx, j + dy)
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    islands++
                    dfs(i, j)
                }
            }
        }

        return islands
    }

    fun numIslandsB(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val visited = Array(rows) { BooleanArray(cols) { false } }

        val uf = UnionFind(rows * cols)

        fun composeIsland(root: Int, i: Int, j: Int) {
            if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || visited[i][j])
                return

            uf.union(root, i * cols + j)
            visited[i][j] = true

            for ((dr, dc) in listOf((1 to 0), (-1 to 0), (0 to 1), (0 to -1))) {
                composeIsland(root,i + dr, j + dc)
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    composeIsland(i * cols + j, i, j)
                }
            }
        }

        val islands = mutableSetOf<Int>()
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    islands.add(uf.find(i * cols + j))
                }
            }
        }

        return islands.size
    }
}

private class UnionFind(sz: Int) {
    val entities = Array(sz) { Entity(it, 0) }

    data class Entity(var parent: Int, var rank: Int)

    fun find(e: Int): Int {
        if (entities[e].parent == e)
            return e

        val parent = find(entities[e].parent)
        entities[e].parent = parent

        return parent
    }

    fun union(e1: Int, e2: Int) {
        val parent1 = find(e1)
        val parent2 = find(e2)

        if (parent1 == parent2)
            return

        if (entities[parent1].rank > entities[parent2].rank) {
            entities[parent2].parent = parent1
        } else if (entities[parent1].rank < entities[parent2].rank) {
            entities[parent1].parent = parent2
        } else {
            entities[parent2].parent = parent1
            entities[parent1].rank++
        }
    }
}

fun main() {
    val s = NumberofIslands200()

    println(
        s.numIslandsB(
            arrayOf(
                charArrayOf('1'),
                charArrayOf('1'),
            )
        )
    )

//    println(
//        s.numIslandsB(
//            arrayOf(
//                charArrayOf('1', '0', '0'),
//                charArrayOf('0', '1', '0'),
//                charArrayOf('0', '0', '1'),
//            )
//        )
//    )

//    println(
//        s.numIslandsB(
//            arrayOf(
//                charArrayOf('1', '1', '0'),
//                charArrayOf('1', '1', '0'),
//                charArrayOf('0', '0', '1'),
//            )
//        )
//    )

    /*

    0 1 2 3 4
    5 6 7 8 9
    10 11 12 13 14
    15 16 17 18 19

    idx = i * rows + j
     */
//    println(
//        s.numIslandsB(
//            arrayOf(
//                charArrayOf('1','1','1','1','0'),
//                charArrayOf('1','1','0','1','0'),
//                charArrayOf('1','1','0','0','0'),
//                charArrayOf('0','0','0','0','0'),
//            )
//        )
//    )
}