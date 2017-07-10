/**
* https://leetcode.com/problems/remove-element
*/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int last = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                last++;
                nums[last] = nums[i];
            }
        }
        
        return last + 1;
    }
}
