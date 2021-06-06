/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
class LongestPalindromicSubstring5 {
    fun longestPalindrome(s: String): String {
        var maxString = ""

        for (i in s.indices) {
            var palindrome = checkPalindrome(s, i, i)
            if (palindrome.length > maxString.length)
                maxString = palindrome
            palindrome = checkPalindrome(s, i, i + 1)
            if (palindrome.length > maxString.length)
                maxString = palindrome
        }

        return maxString
    }

    private fun checkPalindrome(s: String, idxLeft: Int, idxRight: Int): String {
        var l = idxLeft
        var r = idxRight
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        return s.substring(l + 1, r)
    }
}