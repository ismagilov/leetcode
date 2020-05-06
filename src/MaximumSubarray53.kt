import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
class MaximumSubarray53 {
    /**
     * Greedy
     */
    fun maxSubArrayA(nums: IntArray): Int {
        var totalMax = nums[0]
        var curMax = 0

        for (num in nums) {
           curMax = max(num, num + curMax)
           totalMax = max(totalMax, curMax)
        }

        return totalMax
    }

    /**
     * Divide and conquer
     */
    fun maxSubArrayB(nums: IntArray): Int {
        return findMaxSubArray(nums.toList())
    }

    private fun findMaxSubArray(nums: List<Int>): Int {
        if (nums.size == 1)
            return nums[0]

        val mid = nums.size / 2

        val leftMax = findMaxSubArray(nums.slice(0 until mid))
        val rightMax = findMaxSubArray(nums.slice(mid until nums.size))
        val crossMax = crossSum(nums, mid)

        return maxOf(leftMax, crossMax, rightMax)
    }

    private fun crossSum(nums: List<Int>, mid: Int): Int {
        if (nums.size == 1)
            return nums[0]

        var curSum = 0

        var leftMax = Int.MIN_VALUE
        for (i in mid - 1 downTo 0) {
            curSum += nums[i]
            leftMax = max(leftMax, curSum)
        }

        curSum = 0
        var rightMax = Int.MIN_VALUE
        for (i in mid until nums.size) {
            curSum += nums[i]
            rightMax = max(rightMax, curSum)
        }

        println("nums = $nums mid = $mid leftMax + rightMax = ${leftMax + rightMax}")

        return leftMax + rightMax
    }
}

fun main() {
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2)))
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, 6)))
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, 6, -5)))
    println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, -1)))
}