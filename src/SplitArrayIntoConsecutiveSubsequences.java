import java.util.HashMap;

/**
* https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
*/
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Counter counts = new Counter();
        Counter tails = new Counter();
          
        for (int i = 0; i < nums.length; i++)
            counts.add(nums[i], 1);
        
        for (int i = 0; i < nums.length; i++) {
            if (counts.get(nums[i]) == 0) continue;
            counts.add(nums[i], -1);
            
            if (tails.get(nums[i] - 1) > 0) {
                tails.add(nums[i] - 1, -1);
                tails.add(nums[i], 1);
            } else if (counts.get(nums[i] + 1) > 0 && counts.get(nums[i] + 2) > 0) {
                counts.add(nums[i] + 1, -1);
                counts.add(nums[i] + 2, -1);
                tails.add(nums[i] + 2, 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private static class Counter {
        private final HashMap<Integer, Integer> map = new HashMap<>();
        
        private int get(int num) {
            return map.getOrDefault(num, 0);
        }
        
        private void add(int num, int v) {
            map.put(num, get(num) + v);
        }
    }
}
