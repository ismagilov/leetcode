/**
* https://leetcode.com/problems/partition-equal-subset-sum/description/
*
* Using recursion plus memorisation;
*/
public class PartitionEqualSubsetSumB {
    private Boolean[][] cache;
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int n : nums)
            sum += n;
        
        if (sum % 2 == 1)
            return false;
        
        sum /= 2;
        
        cache = new Boolean[nums.length + 1][sum + 1];
        
        return canPartition(nums, nums.length, sum);
    }
    
    private boolean canPartition(int[] nums, int lng, int s) {
        if (s == 0)
            return true;
        
        if (s < 0)
            return false;
        
        if (lng == 0 && s > 0)
            return false;
        
        if (cache[lng][s] == null)
            cache[lng][s] = canPartition(nums, lng - 1, s - nums[lng - 1]) || canPartition(nums, lng - 1, s);
        
        return cache[lng][s];
    }
}
