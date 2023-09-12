import java.lang.IllegalStateException

/**
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum1 {
    fun twoSumA(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val second = target - nums[i]
            map[second]?.let { return intArrayOf(i, it) }
            map[nums[i]] = i
        }

        throw IllegalStateException("Not possible")
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val m = mutableMapOf<Int, Int>()
        for ((i, v) in nums.withIndex()) {
            val other = target - v
            m[other]?.let { return intArrayOf(it, i) }
            m[v] = i
        }

        return intArrayOf()
    }

    /*
    [10, 5, -8, 9, 0]: 1
    [10]
    [10, -5]
     */
}

fun main() {
    println(TwoSum1().twoSum(intArrayOf(2,7,11,15), 9).joinToString(separator = ", "))
    println(TwoSum1().twoSum(intArrayOf(2,19,-10,15), 9).joinToString(separator = ", "))
    println(TwoSum1().twoSum(intArrayOf(3,3), 6).joinToString(separator = ", "))
    println(TwoSum1().twoSum(intArrayOf(10, 5, -8, 9, 0), 1).joinToString(separator = ", "))
}