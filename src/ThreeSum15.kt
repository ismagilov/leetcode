class ThreeSum15 {
    /*
    [-1,0,1,2,-1,-4]
    [-4,-1,-1,0,1,2]
     */
    fun threeSum(inputNums: IntArray): List<List<Int>> {
        val nums = inputNums.sorted()

        val result: MutableList<List<Int>> = mutableListOf()
        val indices = nums.indices
        for (i in indices) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue

            val targetSum = -nums[i]
            val pair = twoSumHash(nums, targetSum, i + 1, indices.last)
            pair.forEach {
                result.add(listOf(nums[i]) + it)
            }
        }

        return result
    }

    //[-4,-1,[-1,0,1,2]]
    private fun twoSumHash(nums: List<Int>, targetSum: Int, start: Int, end: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val cache = mutableSetOf<Int>()
        var i = start
        while (i <= end) {
            //targetSum = nums[i] + target
            val target = targetSum - nums[i]
            if (cache.contains(target)) {
                result.add(listOf(nums[i], target))
                while (i + 1 <= end && nums[i + 1] == nums[i])
                    i++
            }
            cache.add(nums[i])
            i++
        }

        return result
    }

    private fun twoSumSorted(nums: List<Int>, targetSum: Int, start: Int, end: Int): List<List<Int>> {
        var j = start
        var k = end
        val result = mutableListOf<List<Int>>()
        while (j < nums.size && k < nums.size && j < k) {
            val sum = nums[j] + nums[k]
            if (sum == targetSum) {
                result.add(listOf(nums[j], nums[k]))

                while (j < k && nums[j] == nums[j + 1]) j++
                while (j < k && nums[k] == nums[k - 1]) k--

                j++
                k--
            } else if (sum < targetSum) {
                j++
            } else {
                k--
            }
        }

        return result
    }
}

fun main() {
    val s = ThreeSum15()

    println(s.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(s.threeSum(intArrayOf(0, 0, 0)))
}