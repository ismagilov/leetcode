class CombinationSum39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val cndts = candidates.toSortedSet().toList()

        val result = mutableListOf<List<Int>>()
        combination(cndts, 0, mutableListOf(), target, result)

        return result
    }

    private fun combination(
        candidates: List<Int>,
        start: Int,
        combination: MutableList<Int>,
        target: Int,
        result: MutableList<List<Int>>
        ) {
        if (target == 0) {
            result.add(combination.toList())
        }

        if (target < 0)
            return

        for (i in start until candidates.size) {
            combination.add(candidates[i])
            combination(candidates, i, combination, target - candidates[i], result)
            combination.removeLast()
        }
    }
}

fun main() {
    val s = CombinationSum39()

    println(s.combinationSum(intArrayOf(2, 3, 6, 7), 7))
}