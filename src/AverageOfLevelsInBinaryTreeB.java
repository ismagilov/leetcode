import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Breadth first approach.
 */
public class AverageOfLevelsInBinaryTreeB {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> avgs = new ArrayList<>();
        
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                sum += cur.val;
            }
            avgs.add(sum / n);

        }
        
        return avgs;
    }
}
