/**
 * https://leetcode.com/problems/maximum-subarray
 *
 * O(N), one pass loop.
 */
public class MaximumSubarrayA {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSubarrayA m = new MaximumSubarrayA();

        System.out.println(m.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
