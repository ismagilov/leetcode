/**
 * https://leetcode.com/problems/valid-palindrome
 */
class ValidPalindrome125 {
    fun isPalindrome(s: String): Boolean {
        val res = s.toLowerCase().filter { it.isLetterOrDigit() }

        return res == res.reversed()
    }
}

class ValidPalindrome125TwoPointer {
    fun isPalindrome(s: String): Boolean {
        var p1 = 0
        var p2 = s.length - 1

        while (p1 < p2) {
            while (p1 < p2 && s[p1].isLetterOrDigit().not()) p1++
            while (p2 > p1 && s[p2].isLetterOrDigit().not()) p2--

            if (s[p1].toLowerCase() != s[p2].toLowerCase())
                return false

            p1++
            p2--
        }

        return true
    }
}

fun main() {
    println(ValidPalindrome125TwoPointer().isPalindrome("A man, a plan, a canal: Panama"));
    println(ValidPalindrome125TwoPointer().isPalindrome("race a car"));
}