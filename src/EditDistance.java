/**
* https://leetcode.com/problems/edit-distance/description/
*/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int h = word1.length() + 1;
        int w = word2.length() + 1;
        
        int[][] dp = new int[h][w];
        
        for (int i = 0; i < h; i++)
            dp[i][0] = i;
        
        for (int j = 0; j < w; j++)
            dp[0][j] = j;
        
        for (int i = 1; i < h; i++) { //word1
            for (int j = 1; j < w; j++) { //word2
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    //replace: i - 1, j - 1, insert: i, j - 1, delete: i - 1, j
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        
        return dp[h - 1][w - 1];
    }
}
