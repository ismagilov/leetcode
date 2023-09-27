class ValidParentheses20 {
    fun isValid(s: String): Boolean {
        val q = ArrayDeque<Char>()

        for (cur in s) {
            if (cur == '(' || cur == '{' || cur == '[')
                q.addFirst(cur)
            else {
                try {
                    val top = q.removeFirst()
                    if ((top == '(' && cur != ')') || (top == '{' && cur != '}') || (top == '[' && cur != ']'))
                        return false
                } catch (e: NoSuchElementException) {
                    return false
                }
            }
        }

        return q.isEmpty()
    }

    fun isValidB(s: String): Boolean {
        val q = ArrayDeque<Char>()
        val pairs = mapOf(')' to '(', '}' to '{', ']' to '[')
        val openPars = pairs.values.toSet()

        for (c in s) {
            if (c in openPars) {
                q.addFirst(c)
            } else if (q.isNotEmpty()) {
                if (q.first() != pairs[c]) {
                    return false
                } else {
                    q.removeFirst()
                }
            } else {
                return false
            }
        }

        return q.isEmpty()
    }
}

fun main() {
    println(ValidParentheses20().isValidB("[()]"))
    println(ValidParentheses20().isValidB("[()]"))
    println(ValidParentheses20().isValidB("{}(([]))"))
    println(ValidParentheses20().isValidB("{}(([])]"))
    println(ValidParentheses20().isValidB("}(([])]"))
}
