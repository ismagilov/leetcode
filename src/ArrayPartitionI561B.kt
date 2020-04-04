/**
* https://leetcode.com/problems/array-partition-i/
*
* Using sorted array.
*/
class ArrayPartitionI561B {
    fun arrayPairSum(nums: IntArray): Int = nums.asSequence().sorted().filterIndexed { idx, _ ->
            idx % 2 == 0
        }.sum()
}
