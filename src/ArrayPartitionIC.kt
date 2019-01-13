/**
* https://leetcode.com/problems/array-partition-i/solution/
*
* Counting sort, iterate hash array, accumulate sum taking into account odd/even number of occurences
*/
class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        val hash = IntArray(20001)
        
        val shift = 10000
        nums.forEach { hash[it + shift]++ }
        
        var sum = 0
        var carried = 0
        for (i in -10000..10000) {
            val idx = i + shift
            
            sum += (hash[idx] + 1 - carried) / 2 * i
            carried = (hash[idx] + 2 - carried) % 2
        }
        
        return sum
    }
}
