public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        return lps(s, 0, s.length() - 1);
    }

    public int lps(String s, int b, int e) {
        if (b == e)
            return 1;

        if (b + 1 == e && s.charAt(b) == s.charAt(e))
            return 2;

        if (s.charAt(b) == s.charAt(e))
            return lps(s, b + 1, e - 1) + 2;

        return Math.max(lps(s, b + 1, e), lps(s, b, e - 1));
    }
}