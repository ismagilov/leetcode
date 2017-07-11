/**
* https://leetcode.com/problems/contains-duplicate
*/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dupl = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (dupl.contains(nums[i]))
                return true;
            dupl.add(nums[i]);
        }
                
        return false;
    }
}
