import lib.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Using iterative in-order traversal.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInABstC {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        
        TreeNode cur = root;
        int counter = 0;
        while (cur != null || !s.isEmpty()){
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                TreeNode n = s.pop();
                counter++;
                
                if (counter == k)
                    return n.val;
                
                cur = n.right;
            }
        }
        
        return Integer.MIN_VALUE;
    }
}
