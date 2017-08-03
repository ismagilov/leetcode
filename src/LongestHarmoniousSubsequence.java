/**
* https://leetcode.com/problems/longest-harmonious-subsequence
*/
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        
        int max = 0;
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
            
            if (counter.containsKey(n + 1))
                max = Math.max(max, counter.get(n) + counter.get(n + 1));
            
            if (counter.containsKey(n - 1))
                max = Math.max(max, counter.get(n) + counter.get(n - 1));
        }
                
        return max;
    }
}
