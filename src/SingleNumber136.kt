/**
 * https://leetcode.com/problems/single-number/description/
 */
class SingleNumber136 {
    fun singleNumber(nums: IntArray): Int {
        return nums.fold(0, { acc, i -> acc xor i })
    }
}

fun main() {
    println(SingleNumber136().singleNumber(intArrayOf(2, 2, 1)))
}