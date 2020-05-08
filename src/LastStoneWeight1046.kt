import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
class LastStoneWeight1046 {
    fun lastStoneWeightA(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(Comparator { i1, i2 -> i2.compareTo(i1) })

        for (stone in stones)
            heap.offer(stone)

        while (heap.size > 1) {
            val max = heap.poll()
            val nextMax = heap.poll()
            if (max > nextMax)
                heap.offer(max - nextMax)
        }

        return if (heap.size == 1) heap.peek() else 0
    }

    fun lastStoneWeightB(stones: IntArray): Int {
        var maxWeight = stones.max() ?: 0
        val buckets = IntArray(maxWeight + 1)

        for (stoneWeight in stones)
            buckets[stoneWeight]++

        var curWeight = maxWeight
        while (curWeight > 0) {
            if (buckets[curWeight] == 0) {
                curWeight--
                continue
            }

            buckets[curWeight] %= 2
            if (buckets[curWeight] == 0) {
                curWeight--
                continue
            }

            var nextWeight = curWeight - 1
            while (nextWeight > 0 && buckets[nextWeight] == 0)
                nextWeight--

            if (nextWeight == 0)
                return curWeight

            buckets[curWeight]--
            buckets[nextWeight]--
            val newWeight = curWeight - nextWeight
            buckets[newWeight]++

            curWeight = if (newWeight > nextWeight) newWeight else nextWeight
        }

        return 0
    }
}

fun main() {
    println(LastStoneWeight1046().lastStoneWeightB(intArrayOf(2, 7)))
    println(LastStoneWeight1046().lastStoneWeightB(intArrayOf(2, 7, 4, 1, 8, 1)))
}