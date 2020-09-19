/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinationsOfAPhoneNumber17 {
    private val keys = mapOf(
            '2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z")
    )

    /**
     * Recursive backtracking solution.
     */
    fun letterCombinations(digits: String): List<String> {
        return if (digits.isBlank())
            emptyList()
        else
            generateCombinations(StringBuilder(), digits)
    }

    private fun generateCombinations(combination: StringBuilder, digits: String): List<String> {
        if (digits.isEmpty())
            return listOf(combination.toString())

        return keys.getValue(digits[0]).flatMap {
            generateCombinations(StringBuilder(combination).append(it), digits.substring(1))
        }
    }
}

fun main() {
    val solution = LetterCombinationsOfAPhoneNumber17()

    print(solution.letterCombinations("23"))
}