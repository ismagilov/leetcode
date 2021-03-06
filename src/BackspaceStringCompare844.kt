import java.util.LinkedList

class BackspaceStringCompare844 {
    fun backspaceCompareA(S: String, T: String): Boolean {
        val s1 = backspaceString(S)
        val s2 = backspaceString(T)

        return s1 == s2
    }

    private fun backspaceString(s: String): String {
        val stack = LinkedList<Char>()

        s.forEach {
            if (it != '#') {
                stack.push(it)
            } else if (stack.isNotEmpty()) {
                stack.pop()
            }
        }

        return String(stack.toCharArray())
    }

    fun backspaceCompareB(S: String, T: String): Boolean {
        var i = S.length - 1
        var j = T.length - 1
        while (i >= 0 || j >= 0) {
            i = skipChars(S, i)
            j = skipChars(T, j)

            if (i >= 0 && j >= 0 && S[i] != T[j])
                return false
            if ((i >= 0) != (j >= 0))
                return false

            i--
            j--
        }

        return true
    }

    private fun skipChars(s: String, idx: Int): Int {
        var skip = 0
        var i = idx
        while (i >= 0) {
            if (s[i] == '#') {
                skip++
                i--
            } else if (skip > 0) {
                skip--
                i--
            } else {
                break
            }
        }

        return i
    }
}

fun main() {
    println(BackspaceStringCompare844().backspaceCompareB("xywrrmp", "xywrrmu#p"))
}

