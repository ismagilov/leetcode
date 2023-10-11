class BinarySearch704 {
    fun search(nums: IntArray, target: Int): Int {
        var l = -1
        var r = nums.size

        while (l + 1 < r) {
            val mid = l + (r - l) / 2

            when (nums[mid] >= target) {
                true -> r = mid
                false -> l = mid
            }
        }

        return if (r in nums.indices && nums[r] == target) r else -1
    }
}

fun main() {
    val s = BinarySearch704()

    println(s.search(intArrayOf(3, 6, 90, 187), 90))
    println(s.search(intArrayOf(3, 6, 90, 187), 3))
    println(s.search(intArrayOf(3, 6, 90, 187), 187))
    println(s.search(intArrayOf(3, 6, 90, 187), 5))
    println(s.search(intArrayOf(-1,0,3,5,9,12), 13))
    println(s.search(intArrayOf(-1,0,3,5,9,12), -23))
}