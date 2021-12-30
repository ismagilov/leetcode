/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductOfArrayExceptSelf238 {
    /**
     * Time: O(N) Space: O(N)
     */
    fun productExceptSelfA(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        var acc = 1
        for (i in 1 until nums.size) {
            acc *= nums[i - 1]
            result[i] = acc
        }

        acc = 1
        for (i in nums.size - 2 downTo 0) {
            acc *= nums[i + 1]
            result[i] = result[i] * acc
        }

        return result
    }

    /**
     * Time: O(N) Space: O(N)
     */
    fun productExceptSelfB(nums: IntArray): IntArray {
        val left = IntArray(nums.size) { 1 }
        for (i in 1..nums.size - 1)
            left[i] = left[i - 1] * nums[i - 1]

        val right = IntArray(nums.size) { 1 }
        for (i in (0..nums.size - 2).reversed())
            right[i] = right[i + 1] * nums[i + 1]

        return left.zip(right) { l, r -> l * r }.toIntArray()
    }
}

fun main() {
    println(ProductOfArrayExceptSelf238().productExceptSelfB(intArrayOf(6, 2, 3, 4)).toList())
    println(ProductOfArrayExceptSelf238().productExceptSelfB(intArrayOf(1)).toList())
    println(ProductOfArrayExceptSelf238().productExceptSelfB(intArrayOf(2, 3)).toList())
}