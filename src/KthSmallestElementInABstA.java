/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Using recursion with subtree nodes counting.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class KthSmallestElementInABstA {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        
        if (k - count == 1)
            return root.val;
        
        if (k <= count)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - count - 1);
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
}
