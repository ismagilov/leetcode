/**
 * https://leetcode.com/problems/set-mismatch
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);

            if (nums[num - 1] > 0)
                nums[num - 1] *= -1;
            else {
                res[0] = num;
            }
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                res[1] = i + 1;

        return res;
    }

    public static void main(String[] args) {
        SetMismatch s = new SetMismatch();

        int[] res = s.findErrorNums(new int[]{2,2});
        System.out.println(res[0] + ", " + res[1]);
    }
}
