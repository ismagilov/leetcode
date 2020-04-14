class MoveZeros {
    fun moveZeroesA(nums: IntArray): Unit {
        var lastIdx = 0

        for ((curIdx, curVal) in nums.withIndex()) {
            if (curVal != 0) {
                val tmp = nums[curIdx]
                nums[curIdx] = nums[lastIdx]
                nums[lastIdx] = tmp

                lastIdx++
            }
        }

        println(nums.toList())
    }

    fun moveZeroesB(nums: IntArray): Unit {
        var zeros = 0

        for ((curIdx, curVal) in nums.withIndex()) {
            if (curVal == 0) {
                zeros++
            } else {
                swap(nums, curIdx, curIdx - zeros)
            }
        }

        println(nums.toList())
    }

    private fun swap(nums: IntArray, pos1: Int, pos2: Int) {
        val tmp = nums[pos2]
        nums[pos2] = nums[pos1]
        nums[pos1] = tmp
    }
}

fun main() {
    MoveZeros().moveZeroesB(intArrayOf(0, 1, 0, 3, 12))
    MoveZeros().moveZeroesB(intArrayOf(1, 1, 0))
    MoveZeros().moveZeroesB(intArrayOf(1, 0))
    MoveZeros().moveZeroesB(intArrayOf(0, 0, 0, 1))
    MoveZeros().moveZeroesB(intArrayOf())
}
