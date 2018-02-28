/**
* https://leetcode.com/problems/subarray-sum-equals-k/description/
*/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] acc = new int[nums.length + 1];
        
        for (int i = 1; i <= nums.length; i++)
            acc[i] = acc[i - 1] + nums[i - 1];
        
        int count = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
            
        //sum2 - sum1 == k ==> sum2 - k == sum1
        hash.put(0, 1);
        for (int i = 1; i < acc.length; i++) {
            int sum2 = acc[i];
            
            if (hash.containsKey(sum2 - k))
                count += hash.get(sum2 - k);
        
            
            hash.put(sum2, hash.getOrDefault(sum2, 0) + 1);
        }
        
        return count;
    }
}
