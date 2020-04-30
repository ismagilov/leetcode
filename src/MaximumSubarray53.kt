import kotlin.math.max

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
        var totalMax = nums[0]
        var curMax = 0

        for (num in nums) {
            curMax = max(num, num + curMax)
            totalMax = max(totalMax, curMax)
        }

        return totalMax
    }
}

fun main() {
    println(MaximumSubarray53().maxSubArrayA(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(MaximumSubarray53().maxSubArrayA(intArrayOf(-2)))
    println(MaximumSubarray53().maxSubArrayA(intArrayOf(-2, 6, -5)))
}