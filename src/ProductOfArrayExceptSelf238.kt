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

    /*
    [1,2,3,4]
    [1,1,2,6]-->
    [24,12,4,1]<--
     */
    fun productExceptSelfC(nums: IntArray): IntArray {
        val left = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size)
            left[i] = left[i - 1] * nums[i - 1]

        val right = IntArray(nums.size) { 1 }
        for (i in nums.size - 2 downTo 0)
            right[i] = right[i + 1] * nums[i + 1]

        return left.zip(right) { a, b -> a * b }.toIntArray()
    }

    fun productExceptSelfNoExtraArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size)
            result[i] = result[i - 1] * nums[i - 1]

        var right = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] = result[i] * right
            right *= nums[i]
        }

        return result
    }
}

fun main() {
    println(ProductOfArrayExceptSelf238().productExceptSelfNoExtraArray(intArrayOf(6, 2, 3, 4)).toList())
    println(ProductOfArrayExceptSelf238().productExceptSelfNoExtraArray(intArrayOf(1, 2, 3, 4)).toList())
    println(ProductOfArrayExceptSelf238().productExceptSelfNoExtraArray(intArrayOf(-1,1,0,-3,3)).toList())
}