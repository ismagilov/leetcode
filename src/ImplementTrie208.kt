class ImplementTrie {
    val root = TrieNode()

    fun insert(word: String) {
        var iter = root
        for (c in word) {
            iter = iter.nodes.getOrPut(c) { TrieNode() }
        }
        iter.exists = true
    }

    fun search(word: String): Boolean {
        return searchPrefix(word)?.exists ?: false
    }

    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix) != null
    }

    private fun searchPrefix(word: String): TrieNode? {
        var iter = root
        for (c in word) {
            iter = iter.nodes[c] ?: return null
        }

        return iter
    }

    data class TrieNode(
        var exists: Boolean = false,
        val nodes: MutableMap<Char, TrieNode> = mutableMapOf()
    )
}


fun main() {
    val s = ImplementTrie()

    s.insert("pine")
    s.insert("pie")
    s.insert("alpha")
    s.insert("all")

    println(s.search("pie"))
    println(s.search("pi"))

    println(s.startsWith("pi"))
    println(s.startsWith("al"))
    println(s.startsWith("app"))
}
