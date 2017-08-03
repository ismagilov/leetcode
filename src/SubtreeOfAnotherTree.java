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
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return checkSubtree(s, t);
    }
    
    private boolean checkSubtree(TreeNode s, TreeNode t) {
        return s != null && (compare(s, t) || checkSubtree(s.left, t) || checkSubtree(s.right, t));
    }
    
    private boolean compare(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        
        if (s.val == t.val && compare(s.left, t.left) && compare(s.right, t.right))
            return true;
        else
            return false;
    }
}
