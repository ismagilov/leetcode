class MajorityElement169 {
    fun majorityElementA(nums: IntArray): Int {
        return nums.sorted()[nums.size / 2]
    }

    fun majorityElementB(nums: IntArray): Int {
        val m = mutableMapOf<Int, Int>()

        for (n in nums) {
            m.merge(n, 1) { oldv, newv -> oldv + newv }
            if (m.getValue(n) > nums.size / 2)
                return n
        }

        throw IllegalStateException("Not possible due to the task description")
    }

    fun majorityElementC(nums: IntArray): Int {
        var count = 0
        var candidate: Int? = null
        for (n in nums) {
            if (count == 0) candidate = n

            if (candidate == n)
                count++
            else
                count --
        }

        return candidate ?: throw IllegalStateException("Not possible")
    }
}

fun main() {
    val s = MajorityElement169()

    println(s.majorityElementB(intArrayOf(2,2,1,1,1,2,2)))
    println(s.majorityElementB(intArrayOf(2,2,1,1,1)))
}