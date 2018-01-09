/**
* https://leetcode.com/problems/search-for-a-range/description/
*/
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = binarySearch(nums, target, 0, nums.length - 1, true);
        if (res[0] == -1) {
            res[1] = -1;
            return res;
        }

        res[1] = binarySearch(nums, target, res[0], nums.length - 1, false);

        return res;
    }
    
    private int binarySearch(int[] nums, int target, int b, int e, boolean leftBound) {
        int idx = -1;
        
        while (b <= e) {
            int mid = b + (e - b) / 2;
            
            if (nums[mid] == target) {
                idx = mid;
                if (leftBound)
                    e = mid - 1;
                else
                    b = mid + 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else if (nums[mid] < target) {
                b = mid + 1;
            }
        }
        
        return idx;
    }
}
