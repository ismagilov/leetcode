/**
* https://leetcode.com/problems/rotate-array/description/
*
* Using in-place elements rotation.
*/
public class RotateArrayC {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int start = 0;
        int count = 0;
        
        while (count < nums.length) {
            int cur = start;
            int prevTemp = nums[start];
            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = prevTemp;
                prevTemp = temp;
                cur = next;
                count++;
            } while (cur != start);
            
            start++;
        }
    }
}
