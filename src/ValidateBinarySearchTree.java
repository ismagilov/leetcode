import lib.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isInRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isInRange(TreeNode root, long min, long max) {
        if (null == root)
            return true;
        
        boolean isValid = min < root.val && root.val < max;
        
        return isValid && isInRange(root.left, min, root.val) && isInRange(root.right, root.val, max);
    }
}
