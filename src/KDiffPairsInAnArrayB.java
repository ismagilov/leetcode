import java.util.HashSet;

/**
* https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
*
* Time: O(NlogN)
* Space: O(1)
*/ 
public class KDiffPairsInAnArrayB {
   public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
                
        Arrays.sort(nums);
        
        int paired = 0;
        for (int i1 = 1; i1 < nums.length; i1++) {  
            if (nums[i1] == nums[i1 - 1]) {
                paired++;
                while (i1 < nums.length && nums[i1] == nums[i1 - 1])
                    i1++;
            }
        }
            
        if (k == 0)
            return paired;
            
        int cnt = 0;
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1])
                continue;

            int i2 = binarySearch(nums, nums[i1] + k);
            if (i2 != -1)
                cnt++;
        }
                
        return cnt;
    }
    
    private int binarySearch(int[] arr, int x) {
        int b = 0, e = arr.length - 1;
                
        while (b <= e) {
            int mid = b + (e - b) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x) 
                e = mid - 1;
            else if (arr[mid] < x)
                b = mid + 1;
        }
        
        return -1;
    }
}
