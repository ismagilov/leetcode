import java.lang.IllegalStateException

/**
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val second = target - nums[i]
            map[second]?.let { return intArrayOf(i, it) }
            map[nums[i]] = i
        }

        throw IllegalStateException("Not possible")
    }
}

fun main() {
    println(TwoSum1().twoSum(intArrayOf(2,7,11,15), 9).joinToString(separator = ", "))
    println(TwoSum1().twoSum(intArrayOf(2,19,-10,15), 9).joinToString(separator = ", "))
    println(TwoSum1().twoSum(intArrayOf(3,3), 6).joinToString(separator = ", "))
}