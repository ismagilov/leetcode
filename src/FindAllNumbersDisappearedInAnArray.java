import java.util.ArrayList;
import java.util.List;

/**
* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
*/
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;     
            if (nums[idx] > 0)
                nums[idx] *= -1;
        }
        
        List<Integer> missed = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missed.add(i + 1);
        }
        
        return missed;
    }
}
