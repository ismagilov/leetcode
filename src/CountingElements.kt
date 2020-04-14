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
}

fun main() {
    println(CountingElements().countElementsA(intArrayOf(3, 2, 1)))
    println(CountingElements().countElementsA(intArrayOf(1, 2, 3)))
    println(CountingElements().countElementsA(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)))
}