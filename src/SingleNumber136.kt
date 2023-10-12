/**
 * https://leetcode.com/problems/single-number/description/
 */
class SingleNumber136 {
    fun singleNumberA(nums: IntArray): Int {
        return nums.fold(0, { acc, i -> acc xor i })
    }

    fun singleNumberB(nums: IntArray): Int {
        var res = 0
        for (n in nums) {
            res = res xor n
        }

        return res
    }

    fun singleNumberC(nums: IntArray): Int {
        return nums.reduce { res, n -> println("$res : $n"); res xor n }
    }
}

fun main() {
    println(SingleNumber136().singleNumberC(intArrayOf(2, 2, 4, 1, 4)))
}