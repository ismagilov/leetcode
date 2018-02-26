/**
* https://leetcode.com/problems/max-consecutive-ones-ii/description/
*/
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        int z1 = -1;
        int z2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z1 = z2;
                z2 = i;
            }
            
            max = Math.max(max, i - z1);
        }
        
        return max;
    }
}
