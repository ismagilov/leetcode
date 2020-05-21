import kotlin.math.max

class ContiguousArray525 {
    fun findMaxLength(nums: IntArray): Int {
        var maxLength = 0
        var count = 0
        val counts = mutableMapOf(count to -1)
        for ((i, num) in nums.withIndex()) {
            if (num == 0) count--
            else count++

            if (counts.containsKey(count))
                maxLength = max(maxLength, i - counts.getValue(count))
            else
                counts[count] = i
        }

        return maxLength
    }
}

fun main() {
    println(ContiguousArray525().findMaxLength(intArrayOf(0, 1, 0)))
}