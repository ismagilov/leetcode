package lib;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();

        if (root != null)
            traverse(root, "", paths);

        return paths;
    }

    private void traverse(TreeNode cur, String path, List<String> paths) {
        if (cur.left == null && cur.right == null)
            paths.add(path + cur.val);

        if (cur.left != null)
            traverse(cur.left, path + cur.val + "->", paths);

        if (cur.right != null)
            traverse(cur.right, path + cur.val + "->", paths);
    }
}
