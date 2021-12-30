/**
 * https://leetcode.com/problems/contains-duplicate
 */
class ContainsDuplicate217 {
    /**
     * Time: O(NlogN) Space: O(1)
     */
    fun containsDuplicateA(nums: IntArray): Boolean {
        val sorted = nums.sorted()

        sorted.forEachIndexed { i, n ->
            if (i != 0 && n == sorted[i - 1])
                return true
        }

        return false
    }

    /**
     * Time: O(N) Space: O(N) - groupBy() creates a map
     */
    fun containsDuplicateB(nums: IntArray): Boolean {
        return nums
                .groupBy { it }
                .values
                .any { it.size > 1 }
    }

    /**
     * Time: O(N) Space: O(N)
     */
    fun containsDuplicateC(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }
}

fun main() {
    println(ContainsDuplicate217().containsDuplicateA(intArrayOf(9, 0, 0)))
    println(ContainsDuplicate217().containsDuplicateA(intArrayOf(9)))
    println(ContainsDuplicate217().containsDuplicateA(intArrayOf(9, 99, 7, 6)))
}

