/**
* https://leetcode.com/problems/array-partition-i/
*
* Using sorted array.
*/
class Solution {
    fun arrayPairSum(nums: IntArray): Int = nums.asSequence().sorted().filterIndexed { idx, num ->
            idx % 2 == 0
        }.sum()
}
