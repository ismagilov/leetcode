/**
* https://leetcode.com/problems/partition-equal-subset-sum/description/
*
* Using 1-D DP.
*/
public class PartitionEqualSubsetSumA {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int n : nums)
            sum += n;
        
        if (sum % 2 == 1)
            return false;
        
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        for (int n : nums) {
            for (int s = sum; s >= n; s--) {
                dp[s] = dp[s] || dp[s - n];        
            }
        }
        
        return dp[sum];
    }
}
