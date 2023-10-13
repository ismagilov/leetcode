class LongestCommonPrefix14 {
    fun longestCommonPrefixA(strs: Array<String>): String {
        if (strs.isEmpty())
            return ""

        for (i in strs[0].indices) {
            for (j in 1 until strs.size) {
                if (i == strs[j].length || strs[0][i] != strs[j][i])
                    return strs[0].substring(0, i)
            }
        }

        return strs[0]
    }

    fun longestCommonPrefixB(strs: Array<String>): String {
        if (strs.isEmpty())
            return ""

        var l = -1
        var r = strs[0].length
        while (l + 1 < r) {
            val mid = l + (r - l) / 2
            if (isCommonPrefix(strs, strs[0].substring(0, mid + 1))) {
                l = mid
            } else {
                r = mid
            }
        }

        return strs[0].substring(0, l + 1)
    }

    private fun isCommonPrefix(strs: Array<String>, prefix: String): Boolean {
        return strs.all { it.startsWith(prefix) }
    }
}

fun main() {
    val s = LongestCommonPrefix14()
    println(s.longestCommonPrefixB(arrayOf("a", "ab", "ac")))
    println(s.longestCommonPrefixB(arrayOf("", "ab", "ac")))
    println(s.longestCommonPrefixB(arrayOf("ab", "ab", "ab")))
    println(s.longestCommonPrefixB(arrayOf("abc", "abe", "abg")))
}