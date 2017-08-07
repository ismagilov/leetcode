import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS approach.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalIIB {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();

        traverse(root, levels, 0);

        return levels;
    }

    public void traverse(TreeNode root, LinkedList<List<Integer>> levels, int levelNum) {
        if (root == null)
            return;

        if (levelNum == levels.size())
            levels.addFirst(new ArrayList<>());

        List<Integer> level = levels.get(levels.size() - 1 - levelNum);
        level.add(root.val);

        traverse(root.left, levels, levelNum + 1);
        traverse(root.right, levels, levelNum + 1);
    }
}
