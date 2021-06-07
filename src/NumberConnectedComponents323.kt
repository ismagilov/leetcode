/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
 *
 * Disjoint approach.
 */
class NumberConnectedComponents323Disjoint {
    var dj: IntArray = intArrayOf()
    var sz: IntArray = intArrayOf()

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        dj = IntArray(n) { it }
        sz = IntArray(n) { 1 }

        var components = n
        for (e in edges) {
            components -= combine(e[0], e[1])
        }

        return components
    }

    private fun combine(v1: Int, v2: Int): Int {
        val root1 = find(v1)
        val root2 = find(v2)

        if (root1 == root2)
            return 0

        if (sz[root1] > sz[root2]) {
            dj[root2] = root1
            sz[root1] += sz[root2]
        } else {
            dj[root2] = root1
            sz[root2] += sz[root1]
        }

        return 1
    }

    private fun find(v: Int): Int {
        if (dj[v] == v)
            return v

        return find(dj[v])
    }
}

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
 *
 * DFS approach.
 */
class NumberConnectedComponents323Dfs {
    var visited = booleanArrayOf()
    var edgesLists = arrayOf(mutableListOf<Int>())

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        visited = BooleanArray(n) { false }
        edgesLists = Array(n) { mutableListOf() }

        for (e in edges) {
            edgesLists[e[0]].add(e[1])
            edgesLists[e[1]].add(e[0])
        }

        var components = 0
        for (v in 0 until n) {
            if (!visited[v]) {
                components++
                dfs(v)
            }
        }

        return components
    }

    private fun dfs(v: Int) {
        visited[v] = true

        edgesLists[v].filterNot { visited[it] }.forEach { dfs(it) }
    }
}

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
 *
 * BFS approach.
 */
class NumberConnectedComponents323Bfs {
    private var visited = booleanArrayOf()
    private var edgesLists = arrayOf(mutableListOf<Int>())

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        visited = BooleanArray(n) { false }
        edgesLists = Array(n) { mutableListOf() }

        for (e in edges) {
            edgesLists[e[0]].add(e[1])
            edgesLists[e[1]].add(e[0])
        }

        var components = 0
        for (v in 0 until n) {
            if (!visited[v]) {
                components++
                bfs(v)
            }
        }
        return components
    }

    private fun bfs(v: Int) {
        val q = ArrayDeque<Int>(1)

        if (visited[v])
            return
        q.addLast(v)
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            visited[cur] = true

            edgesLists[cur].filterNot { visited[it] }.forEach { q.addLast(it) }
        }
    }
}

fun main() {
    val s = NumberConnectedComponents323Bfs()

    println(s.countComponents(5, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))))
    println(s.countComponents(5, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(3, 4))))
}