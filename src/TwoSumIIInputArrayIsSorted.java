/**
* https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
*/
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] idxs = new int[2];
        
        int b = 0, e = numbers.length - 1;
        while (b < e) {
            int v = numbers[b] + numbers[e];
            
            if (v == target) {
                idxs[0] = b + 1;
                idxs[1] = e + 1;
                break;
            } else if (v > target)
                e--;
            else
                b++;
        }
                
        return idxs;
    }
}
