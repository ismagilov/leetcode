class RansomNote383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val voc = magazine.groupingBy { it }.eachCount().toMutableMap()
        for (c in ransomNote) {
            val counter = voc[c] ?: 0
            if (counter == 0) return false

            voc[c] = counter - 1
        }

        return true
    }
}

fun main() {
    val s = RansomNote383()
    println(s.canConstruct("ab", "ab")) // true
    println(s.canConstruct("abc", "ab")) // false
    println(s.canConstruct("aac", "ac")) // false
    println(s.canConstruct("aac", "aacd")) // true
    println(s.canConstruct("db", "abcde")) // true
}