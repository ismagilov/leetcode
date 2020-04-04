import lib.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DiameterOfBinaryTree {
    private int res = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calcDiameter(root);
        
        return res;
    }
    
    private int calcDiameter(TreeNode root) {
         if (root == null)
            return 0;
        
        int left = calcDiameter(root.left);
        int right = calcDiameter(root.right);
        
        res = Math.max(res, left + right);
        
        return 1 + Math.max(left, right);
    }
}
