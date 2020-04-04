/**
* https://leetcode.com/problems/kth-largest-element-in-an-array/description/
*
* Using quick select approach.
*/

import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int findKthLargest(int[] nums, int l, int r, int k) {
        int pivotIdx = partition(nums, l, r);
        
        if (pivotIdx == k)
            return nums[k];
        else if (pivotIdx < k)
            return findKthLargest(nums, pivotIdx + 1, r, k);
        else
            return findKthLargest(nums, l, pivotIdx - 1, k);
    }
    
    private int partition(int[] nums, int l, int r) {
        Random rand = new Random();
        int pivotIdx = l + rand.nextInt(r - l + 1);
        
        int pivot = nums[pivotIdx];
        
        swap(nums, r, pivotIdx);
        int storeIdx = l;
        
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, storeIdx);
                storeIdx++;
            }
        }
        
        swap(nums, storeIdx, r);
        
        return storeIdx;
    }
    
    private void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
