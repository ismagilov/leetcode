public class LongestPalindromicSubsequence {
    private int [][]mem;

    public int longestPalindromeSubseq(String s) {
        mem = new int[s.length()][s.length()];

        return lps(s, 0, s.length() - 1);
    }

    public int lps(String s, int b, int e) {
        if (mem[b][e] > 0)
            return mem[b][e];

        if (b == e)
            mem[b][e] = 1;
        else if (b + 1 == e && s.charAt(b) == s.charAt(e))
            mem[b][e] = 2;
        else if (s.charAt(b) == s.charAt(e))
            mem[b][e] = lps(s, b + 1, e - 1) + 2;
        else
            mem[b][e] = Math.max(lps(s, b + 1, e), lps(s, b, e - 1));

        return mem[b][e];
    }
}