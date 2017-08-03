import java.util.Arrays;

/**
* https://leetcode.com/problems/shortest-unsorted-continuous-subarray
*
* Solved using sorting of original array and comparing it with original.
*/
public class ShortestUnsortedContinuousSubarrayA {
    public int findUnsortedSubarray(int[] nums) {        
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        
        int b = 0, e = nums.length - 1;
        while (b <= e && (nums[b] == sorted[b] || nums[e] == sorted[e])) {
            if (nums[b] == sorted[b]) 
                b++;
            if (nums[e] == sorted[e])
                e--;
        }
        
        return b <= e ? e - b + 1 : 0;
    }
}
