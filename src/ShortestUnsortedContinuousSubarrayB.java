/**
* https://leetcode.com/problems/shortest-unsorted-continuous-subarray
*
* Solved by searchin min and max in unsorted subarray, and getting their correct indexes in sorted array.
*/
public class ShortestUnsortedContinuousSubarrayB {
    public int findUnsortedSubarray(int[] nums) {
        boolean found = false;
    
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                found = true;
            
            if (found)
                min = Math.min(min, nums[i]);
        }
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                found = true;
            
            if (found)
                max = Math.max(max, nums[i]);
        }
        
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min)
                break;
        }
        
        for (r = nums.length - 1; r >= 0; r--) {
            if (nums[r] < max)
                break;
        }
        
        return r > l ? r - l + 1 : 0;
    }
}
