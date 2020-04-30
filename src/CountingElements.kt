class CountingElements {
    fun countElementsA(arr: IntArray): Int {
        val hash = arr.toSet()

        var result = 0
        arr.forEach { num ->
            if (hash.contains(num + 1))
                result++
        }

        return result
    }

    fun countElementsB(arr: IntArray): Int {
        val hash = mutableMapOf<Int, Int>()

        var result = 0
        for (v in arr) {
            hash[v + 1]?.let { result++ }

            if (!hash.containsKey(v)) {
                hash[v - 1]?.let { result += it }
                hash[v] = 1
            } else {
                hash[v] = (hash[v] ?: 0) + 1
            }
        }

        return result
    }
}

fun main() {
    println(CountingElements().countElementsB(intArrayOf(3, 2, 1)))
    println(CountingElements().countElementsB(intArrayOf(1, 2, 3)))
    println(CountingElements().countElementsB(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)))
    println(CountingElements().countElementsB(intArrayOf(1, 1, 2, 2)))
    println(CountingElements().countElementsB(intArrayOf(0, 4, 0, 2, 7, 2, 1, 7)))
}