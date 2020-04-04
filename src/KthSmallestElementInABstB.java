import lib.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Using extra array and recursive in-order traversal.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInABstB {
    private ArrayList<Integer> values = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        if (values.size() == k)
            return values.get(k - 1);
        
        inOrder(root, k);
        
        return values.get(k - 1);
    }
    
    private void inOrder(TreeNode root, int k) {
        if (root == null) return;
        
        if (values.size() >= k) return;
        
        inOrder(root.left, k);
        values.add(root.val);
        inOrder(root.right, k);
    }
    
}
