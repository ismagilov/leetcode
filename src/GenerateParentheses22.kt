class GenerateParentheses22 {
    private var result = mutableListOf<String>()

    fun generateParenthesisA(n: Int): List<String> {
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

    fun generateParenthesisB(n: Int): List<String> {
        val result = mutableListOf<String>()

        val q = ArrayDeque<Sequence>()

        q.addLast(Sequence("", 0, 0))
        while(q.isNotEmpty()) {
            val head = q.removeFirst()

            if (head.s.length == 2 * n) {
                result.add(head.s)
                continue;
            }

            if (head.open < n)
                q.addLast(Sequence(head.s + "(", head.open + 1, head.close))

            if (head.close < head.open)
                q.addLast(Sequence(head.s + ")", head.open, head.close + 1))
        }

        return result
    }

    private data class Sequence(val s: String, val open: Int, val close: Int)

}

fun main() {
    val a = GenerateParentheses22()

    println(a.generateParenthesisB(2))
}

