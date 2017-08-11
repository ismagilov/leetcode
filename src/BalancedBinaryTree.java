import lib.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return trackDepth(root, 1) != -1;
    }

    private int trackDepth(TreeNode node, int depth) {
        if (node == null)
            return depth;

        int l = trackDepth(node.left, depth + 1);
        if (l == -1) return -1;

        int r = trackDepth(node.right, depth + 1);
        if (r == -1) return -1;

        if (Math.abs(l - r) <= 1)
            return Math.max(l, r);
        else
            return -1;
    }
}
