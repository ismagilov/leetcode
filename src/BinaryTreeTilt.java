import lib.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-tilt 
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeTilt {
    private int left;
    private int right;
    
    public int findTilt(TreeNode root) {
        if (null == root)
            return 0;
        
        int tilt = Math.abs(sumSubtree(root.left) - sumSubtree(root.right));
            
        return tilt + findTilt(root.left) + findTilt(root.right);
    }
    
    public int sumSubtree(TreeNode node) {
        if (node == null)
            return 0;
        
        return node.val + sumSubtree(node.left) + sumSubtree(node.right);
    }
}
