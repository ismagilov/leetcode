import lib.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LongestUnivaluePath {
    private int res = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        
        longest(root);
        
        return res;
    }
    
    private int longest(TreeNode root) {
        if (root == null) return 0;
    
        int left = longest(root.left);
        int right = longest(root.right);
        
        int pathLeft = 0, pathRight = 0;
        if (root.left != null && root.val == root.left.val)
            pathLeft = left + 1;
        if (root.right != null && root.val == root.right.val)
            pathRight = right + 1;
        
        res = Math.max(res, pathLeft + pathRight);
        
        return Math.max(pathLeft, pathRight);
    }
}
