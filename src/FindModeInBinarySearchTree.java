/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindModeInBinarySearchTree {
    private final ArrayList<Integer> modes = new ArrayList<>();
    private int maxNum = -1;
    private int num = 1;
    private Integer prev = null;
    
    
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        
        traverse(root);
        
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++)
            res[i] = modes.get(i);
        
        return res;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        
        traverse(root.left);
        if (prev != null) {
            if (prev == root.val)
                num++;
            else
                num = 1;
        }
        
        if (num > maxNum) {
            modes.clear();
            modes.add(root.val);
            maxNum = num;
        } else if (num == maxNum) {
            modes.add(root.val);
        }
        
        prev = root.val;
        traverse(root.right);
    }
}
