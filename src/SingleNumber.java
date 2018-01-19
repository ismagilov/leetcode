/**
* https://leetcode.com/problems/single-number/description/
*/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums)
            res ^= n;
        
        return res;
    }
}
