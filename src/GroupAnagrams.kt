class GroupAnagrams {
    /**
     * Group by sorted strings.
     */
    fun groupAnagramsA(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, List<String>>()

        for (str in strs) {
            groups.merge(String(str.toCharArray().apply { sort() }), listOf(str)) { o, n ->
                if (o != null)
                    o + n
                else
                    n
            }
        }

        return groups.values.toList()
    }

    /**
     * Group by array with counted symbols.
     */
    fun groupAnagramsB(strs: Array<String>): List<List<String>> {
        return strs
            .groupBy { s ->
                IntArray(26)
                    .apply { s.forEach { c -> this[c - 'a']++ } }
                    .joinToString(separator = "#")
            }
            .values.toList()
    }
}

fun main() {
    val anagrams = GroupAnagrams()

    println(anagrams.groupAnagramsB(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}