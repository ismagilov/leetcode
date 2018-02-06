/**
* https://leetcode.com/problems/max-consecutive-ones/description/
*/
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int n : nums) {
            if (n == 1) {
                cnt++;
                max = Math.max(cnt, max);
            } else {
                cnt = 0;
            }
        }
        
        return max;
    }
}
