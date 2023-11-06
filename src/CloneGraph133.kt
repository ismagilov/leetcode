class CloneGraph133 {
    val visited = mutableMapOf<Node, Node>()

    fun cloneGraphBfs(node: Node?): Node? {
        val q = ArrayDeque<Node>()

        if (node == null)
            return null
        val cloned = mutableMapOf<Node, Node>()

        q.addLast(node)
        cloned[node] = Node(node.`val`)

        while (q.isNotEmpty()) {
            val head = q.removeFirst()

            for (neighbor in head.neighbors) {
                if (neighbor == null) continue

                if (!cloned.containsKey(neighbor)) {
                    cloned[neighbor] = Node(neighbor.`val`)
                    q.add(neighbor)
                }

                cloned[head]?.neighbors?.add(cloned[neighbor])
            }
        }

        return cloned[node]
    }

    fun cloneGraphDfs(node: Node?): Node? {
        if (node == null)
            return null

        if (visited.containsKey(node))
            return visited[node]

        val cloned = Node(`val` = node.`val`)
        visited[node] = cloned

        val clonedNeighbours = node.neighbors
            .map { cloneGraphDfs(it) }
        cloned.neighbors.addAll(clonedNeighbours)

        return cloned
    }

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList()
    }
}