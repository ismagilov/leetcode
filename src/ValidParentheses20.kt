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
                        return false;
                } catch (e: NoSuchElementException) {
                    return false
                }
            }
        }

        return q.isEmpty()
    }
}

fun main() {
    println(ValidParentheses20().isValid("[()]"))
    println(ValidParentheses20().isValid("[()]"))
    println(ValidParentheses20().isValid("{}(([]))"))
    println(ValidParentheses20().isValid("{}(([])]"))
}