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

    fun backspaceCompareC(s: String, t: String): Boolean {
        fun erased(s: String): ArrayDeque<Char> {
            val stack = ArrayDeque<Char>()

            for (c in s) {
                if (c == '#' && stack.isNotEmpty())
                    stack.removeFirst()
                else if (c != '#')
                    stack.addFirst(c)
            }

            return stack
        }

        return erased(s) == erased(t)
    }

    fun backspaceCompareD(s: String, t: String): Boolean {
        var i = s.length - 1
        var j = t.length - 1

        while (i >= 0 || j >= 0) {
            var skipI = 0
            while (i >= 0) {
                if (s[i] == '#') { skipI++; i-- }
                else if (skipI > 0) { skipI--; i-- }
                else { break }
            }

            var skipJ = 0
            while (j >= 0) {
                if (t[j] == '#') { skipJ++; j-- }
                else if (skipJ > 0) { skipJ--; j-- }
                else { break }
            }

            if (i >= 0 && j >= 0 && s[i] != t[j]) return false
            if ((i >= 0) != (j >= 0)) return false // "ab##" "abc#"

            i--; j--
        }

        return true
    }
}

fun main() {
    println(BackspaceStringCompare844().backspaceCompareD("p", "pb#"))
    println(BackspaceStringCompare844().backspaceCompareD("xywrrmp", "xywrrmu#p"))
    println(BackspaceStringCompare844().backspaceCompareD("###c", "#c#c"))
    println(BackspaceStringCompare844().backspaceCompareD("abc", "def"))
    println(BackspaceStringCompare844().backspaceCompareD("ab#c", "acdef###"))
}

