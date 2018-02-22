/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
 *
 * Bottom-up recursive approach.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxLng = 0;
    
    public int longestConsecutive(TreeNode root) {
        findLongest(root);
        
        return maxLng;
    }
    
    private int findLongest(TreeNode root) {
        if (root == null)
            return 0;
        
        int l = findLongest(root.left) + 1;
        int r = findLongest(root.right) + 1;
        
        if (root.left != null && root.val + 1 != root.left.val)
            l = 1;
        if (root.right != null && root.val + 1 != root.right.val)
            r = 1;
        
        int lng = Math.max(l, r);
        maxLng = Math.max(lng, maxLng);
        
        return lng;
    }
}
