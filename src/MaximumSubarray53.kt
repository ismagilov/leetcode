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

    fun maxSubArrayC(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in nums.indices) {
            var subMax = 0
            for (j in i..<nums.size) {
                subMax += nums[j]
                max = max(max, subMax)
            }
        }

        return max
    }

    fun maxSubArrayD(nums: IntArray): Int {
        var cur = nums[0]
        var max = nums[0]

        for (i in 1 until nums.size) {
            cur = max(cur + nums[i], nums[i])
            max = max(max, cur)
        }

        return max
    }
}

fun main() {
    val s = MaximumSubarray53()

    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2)))
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, 6)))
    // println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, 6, -5)))
//    println(MaximumSubarray53().maxSubArrayB(intArrayOf(-2, -1)))
    println(s.maxSubArrayD(intArrayOf(5, 4, -1, 7, 8)))
}