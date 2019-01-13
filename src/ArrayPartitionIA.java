/**
* https://leetcode.com/problems/array-partition-i
*
* Use counting sort.
*/
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        int[] sorted = new int [20001];
        
        for (int i = 0; i < nums.length; i++)
            sorted[nums[i] + 1000]++;
        
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < sorted.length; i++) {
            while (sorted[i] > 0) {
                if (odd)
                    sum += i - 1000;
                    
                odd = !odd;
                sorted[i]--;
            }
        }
        
        return sum;
    }
}
