/**
* https://leetcode.com/problems/move-zeroes/#/description
*/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int last = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                if (last != cur) {
                    int tmp = nums[cur];
                    nums[cur] = nums[last];
                    nums[last] = tmp;
                }
                
                last++;
            }
        }
    }
}
