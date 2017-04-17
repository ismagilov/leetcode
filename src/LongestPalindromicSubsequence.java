/**
* https://leetcode.com/problems/longest-palindromic-subsequence
*/
public class LongestPalindromicSubsequence {
    private int [][]cnts;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        
        cnts = new int[n][n];
        
        for (int i = 0; i < n; i++)
            cnts[i][i] = 1;
        
        for (int l = 2; l <= n; l++) {
            for (int b = 0; b <= n - l; b++) {
                int e = b + l - 1;
                
                if (l == 2 && s.charAt(b) == s.charAt(e))
                    cnts[b][e] = 2;
                else if (s.charAt(b) == s.charAt(e))
                    cnts[b][e] = cnts[b + 1][e - 1] + 2;
                else 
                    cnts[b][e] = Math.max(cnts[b + 1][e], cnts[b][e - 1]);
            }
        }    

        return cnts[0][n - 1];
    }
}
