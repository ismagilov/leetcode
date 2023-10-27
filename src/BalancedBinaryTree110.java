public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        return trackHeight(root).balanced;
    }

    private Height trackHeight(TreeNode root) {
        if (root == null) {
            return new Height(0, true);
        }

        Height left = trackHeight(root.left);
        Height right = trackHeight(root.right);

        int currentHeight = Math.max(left.h, right.h) + 1;
        if (left.balanced && right.balanced && Math.abs(left.h - right.h) <= 1) {
            return new Height(currentHeight, true);
        } else {
            return new Height(currentHeight, false);
        }
    }

    private class Height {
        int h;
        boolean balanced;

        public Height(int h, boolean balanced) {
            this.h = h;
            this.balanced = balanced;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

