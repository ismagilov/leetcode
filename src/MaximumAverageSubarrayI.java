/**
 * https://leetcode.com/problems/maximum-average-subarray-i
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];

        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];

            max = Math.max(max, sum);
        }

        return max / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI m = new MaximumAverageSubarrayI();

        System.out.println(m.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
    }
}
