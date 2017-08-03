/**
 * https://leetcode.com/problems/range-sum-query-immutable
 */
public class RangeSumQueryImmutable {
    private int[] nums;
    private int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
            sums[i + 1] = sums[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
