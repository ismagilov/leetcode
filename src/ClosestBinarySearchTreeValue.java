import lib.TreeNode;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/description/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode next = target < root.val ? root.left : root.right;        
        if (next == null)
            return root.val;
        
        int closest = closestValue(next, target);       
        
        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }
}
