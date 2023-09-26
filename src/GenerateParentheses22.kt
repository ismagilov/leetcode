class GenerateParentheses22 {
    private var result = mutableListOf<String>()

    fun generateParenthesis(n: Int): List<String> {
        generate("", 0, 0, n)

        return result
    }

    private fun generate(s: String, open: Int, close: Int, max: Int) {
        if (open == close && open == max) {
            result.add(s)
            return
        }

        if (open < max)
            generate("$s(", open + 1, close, max)

        if (close < open)
            generate("$s)", open, close + 1, max)
    }
}

fun main() {
    val a = GenerateParentheses22()

    println(a.generateParenthesis(2))
}

