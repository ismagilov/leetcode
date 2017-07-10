/**
* https://leetcode.com/problems/remove-element
*
* Swap element equal to val with current last element. After swapping recheck new element.
*/
public class RemoveElementB {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        
        int i = 0;
        while (i <= last) {
            if (nums[i] == val) {
                nums[i] = nums[last];
                last--;
            } else {
                i++;
            }
        }
        
        return last + 1;
    }
}
