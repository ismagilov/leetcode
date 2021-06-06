import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
class LongestConsecutiveSequence128 {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toSet()

        var maxLength = 0
        numsSet.forEach { n ->
            if (numsSet.contains(n - 1))
                return@forEach

            var length = 0
            var it = n
            while (numsSet.contains(it)) {
                length++
                it++
            }

            maxLength = max(maxLength, length)
        }

        return maxLength
    }
}

fun main() {
    val s = LongestConsecutiveSequence128()

    println(s.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}