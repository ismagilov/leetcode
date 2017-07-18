/**
 * https://leetcode.com/problems/construct-string-from-binary-tree
 *
 * Traverse using stack. 
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructStringFromBinaryTreeB {
    private StringBuilder sb = new StringBuilder();
    
    public String tree2str(TreeNode t) {
        if (null == t)
            return "";
        
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        stack.push(t);
        while (!stack.empty()) {
            TreeNode n = stack.peek();
            
            if (visited.contains(n)) {
                sb.append(")");
                stack.pop();
            } else {
                visited.add(n);
                
                sb.append("(").append(n.val);
                if (n.left == null && n.right != null)
                    sb.append("()");

                if (n.right != null)
                    stack.push(n.right);

                if (n.left != null)
                    stack.push(n.left);
            }
        }
        
        return sb.substring(1, sb.length() - 1);
    }
}
