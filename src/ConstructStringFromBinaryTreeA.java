/**
 * https://leetcode.com/problems/construct-string-from-binary-tree
 *
 * Traverse using recursion. 
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructStringFromBinaryTreeA {
    private StringBuilder sb = new StringBuilder();
    
    public String tree2str(TreeNode t) {
        traverse(t);
        
        return sb.toString();
    }
    
    private void traverse(TreeNode t) {
        if (t == null)
            return;
        
        if (t.left == null && t.right == null) {    
            sb.append(t.val);
            return;
        } else if (t.right == null) {
            sb.append(t.val).append("(");
            traverse(t.left);
            sb.append(")");
            return;
        } else { //left == null && right !=null OR left != null && right != null
            sb.append(t.val).append("(");
            traverse(t.left);
            sb.append(")").append("(");
            traverse(t.right);
            sb.append(")");
            return;
        }
    }
}
