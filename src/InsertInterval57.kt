import java.lang.Integer.max
import java.lang.Integer.min

class InsertInterval57 {
    fun insertA(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = intervals.toList().toMutableList()
        val pos = result.binarySearch(newInterval, { s1, s2 -> s1[0].compareTo(s2[0]) })

        val insertPos = when {
            pos < 0 -> -pos - 1
            else -> pos
        }
        result.add(insertPos, newInterval)

        var cur = when {
            insertPos == 0 -> 0
            else -> insertPos - 1
        }

        while (cur + 1 < result.size) {
            if (!intersect(result[cur], result[cur + 1])) {
                // Edge case: [2,5] new:[6,10] [7,10]
                // Even though a new interval can be non-intersecting with the one before,
                // we need to move forward to check if a new interval intersects with the following interval
                cur++
                continue
            }

            val mergedInterval = union(result[cur], result[cur + 1])
            result.add(cur, mergedInterval)
            result.removeAt(cur + 1)
            result.removeAt(cur + 1)
        }

        return result.toTypedArray()
    }

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        var iter = 0
        while (iter < intervals.size && intervals[iter][1] < newInterval[0]) {
            result.add(intervals[iter])
            iter++
        }

        var mergedInterval = newInterval
        while (iter < intervals.size && intersect(intervals[iter], mergedInterval)) {
           mergedInterval = union(intervals[iter], mergedInterval)
           iter++
        }

        result.add(mergedInterval)

        while (iter < intervals.size) {
            result.add(intervals[iter])
            iter++
        }

        return result.toTypedArray()
    }

    private fun intersect(i1: IntArray, i2: IntArray) = max(i1[0], i2[0]) <= min(i1[1], i2[1])

    private fun union(i1: IntArray, i2: IntArray) = intArrayOf(min(i1[0], i2[0]), max(i1[1], i2[1]))
}

fun main() {
    val s = InsertInterval57()

    printArr(s.insertA(
        arrayOf(intArrayOf(0,3), intArrayOf(5,8), intArrayOf(9,11)),
        intArrayOf(9,18))
    )
    printArr(s.insert(
        arrayOf(intArrayOf(0,5), intArrayOf(9,12)),
        intArrayOf(7,16))
    )
//    printArr(s.insert(
//        arrayOf(intArrayOf(1,5)),
//        intArrayOf(1,7))
//    )
//    printArr(s.insert(
//        arrayOf(intArrayOf(1,2), intArrayOf(3,5), intArrayOf(6,7), intArrayOf(8,10), intArrayOf(12,16)),
//        intArrayOf(4,8))
//    )
}

fun printArr(arr: Array<IntArray>) {
    print("[")
    print(arr.joinToString { it.contentToString() })
    println("]")
}