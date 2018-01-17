/**
* https://leetcode.com/problems/missing-number/description/
*/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i])
                return i;
        
        return nums.length;
    }
}
