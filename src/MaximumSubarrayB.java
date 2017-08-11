/**
 * https://leetcode.com/problems/maximum-subarray
 *
 * Divide and conquer.
 */
public class MaximumSubarrayB {
    public int maxSubArray(int[] nums) {
        return findMax(nums, 0, nums.length - 1);
    }

    private int findMax(int[] nums, int s, int f) {
        if (s == f)
            return nums[s];

        int mid = s + (f - s) / 2;

        int m1 = findMax(nums, s, mid);
        int m2 = findMax(nums, mid + 1, f);

        int sum = 0;
        int ls = Integer.MIN_VALUE;
        for (int i = mid; i >= 0; i--) {
            sum += nums[i];
            ls = Math.max(ls, sum);
        }

        sum = 0;
        int rs = Integer.MIN_VALUE;
        for (int i = mid + 1; i < nums.length; i++) {
            sum += nums[i];
            rs = Math.max(rs, sum);
        }

        return Math.max(ls + rs, Math.max(m1, m2));
    }

    public static void main(String[] args) {
        MaximumSubarrayB m = new MaximumSubarrayB();

        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
