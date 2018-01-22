/**
* https://leetcode.com/problems/rotate-array/description/
*
* Using extra array.
*/
public class RotateArrayB {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        int[] extra = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            extra[(i + k) % nums.length] = nums[i];
        
        for (int i = 0; i < nums.length; i++)
            nums[i] = extra[i];
    }
}
