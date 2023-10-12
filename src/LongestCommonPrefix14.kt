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
        return ""
    }
}

fun main() {
}