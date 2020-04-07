import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
class LongestSubstringWithAtMostKDistinctCharacters340 {
    /**
     * Sliding window and chars counting.
     */
    fun lengthOfLongestSubstringKDistinct1(s: String, k: Int): Int {
        var start = 0
        var maxLength = 0
        val uniqueCharsCnt = mutableMapOf<Char, Int>()
        for (end in s.indices) {
            uniqueCharsCnt.merge(s[end], 1) { v, add -> v + add }

            while (uniqueCharsCnt.size > k) {
                uniqueCharsCnt.merge(s[start], 1) { v, sub -> if (v != sub) v - sub else null }
                start++
            }

            maxLength = max(end - start + 1, maxLength)
        }

        return maxLength
    }

    /**
     * Sliding window and removing the most left char if number of distinct chars exceeds.
     */
    fun lengthOfLongestSubstringKDistinct2(s: String, k: Int): Int {
        var start = 0

        var maxLength = 0
        val uniqueCharsLastIdx = mutableMapOf<Char, Int>()
        for (end in s.indices) {
            uniqueCharsLastIdx[s[end]] = end

            if (uniqueCharsLastIdx.size == k + 1) {
                val left = uniqueCharsLastIdx.values.min() ?: throw IllegalStateException()
                uniqueCharsLastIdx.remove(s[left])
                start = left + 1
            }

            maxLength = max(end - start + 1, maxLength)
        }

        return maxLength
    }

    /**
     * Sliding window and removing the most left char if number of distinct chars exceeds.
     * Use linked hash map for getting the most left character with O(1) time.
     */
    fun lengthOfLongestSubstringKDistinct3(s: String, k: Int): Int {
        var start = 0

        var maxLength = 0
        val uniqueCharsLastIdx = linkedMapOf<Char, Int>()
        for (end in s.indices) {
            if (uniqueCharsLastIdx.containsKey(s[end]))
                uniqueCharsLastIdx.remove(s[end])
            uniqueCharsLastIdx[s[end]] = end

            if (uniqueCharsLastIdx.size == k + 1) {
                val leftIdx = uniqueCharsLastIdx.entries.first().value
                uniqueCharsLastIdx.remove(s[leftIdx])
                start = leftIdx + 1
            }

            maxLength = max(end - start + 1, maxLength)
        }

        return maxLength
    }
}

fun main() {
    println(LongestSubstringWithAtMostKDistinctCharacters340().lengthOfLongestSubstringKDistinct3("abaccc", 2))
}