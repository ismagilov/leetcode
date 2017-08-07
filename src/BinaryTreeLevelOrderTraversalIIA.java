import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS approach.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 */
public class BinaryTreeLevelOrderTraversalIIA {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();

        if (null == root)
            return levels;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode tn = q.poll();
                level.add(tn.val);

                if (tn.left != null) q.offer(tn.left);
                if (tn.right != null) q.offer(tn.right);
            }

            levels.addFirst(level);
        }

        return levels;
    }
}
