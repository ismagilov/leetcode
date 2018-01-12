/**
* https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
*/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] acc = new int[nums1.length];
        int last = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                acc[last] = nums1[i1];
                last++;
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else { //nums1[i1] > nums2[i2]
                i2++;
            }
        }
        
        return Arrays.copyOf(acc, last);
    }
}
