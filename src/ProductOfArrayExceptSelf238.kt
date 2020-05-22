/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductOfArrayExceptSelf238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var acc = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] = result[i] * acc

            acc *= nums[i]
        }

        return result
    }
}

fun main() {
    println(ProductOfArrayExceptSelf238().productExceptSelf(intArrayOf(1, 2, 3, 4)).toList())
    println(ProductOfArrayExceptSelf238().productExceptSelf(intArrayOf(0, 0)).toList())
}