/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree 
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Depth first approach.
 */
public class AverageOfLevelsInBinaryTreeA {
    private List<Double> res = new ArrayList<>();
    private List<Integer> cnt = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        next(root, 0);
        
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(Arrays.toString(cnt.toArray()));
        
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / cnt.get(i));
       
        return res;
    }
    
    private void next(TreeNode node, int level) {
        if (node == null)
            return;
        
        if (level == res.size()) {
            res.add(level, (double)node.val);
            cnt.add(level, 1);
        } else {
            res.set(level, res.get(level) + node.val);
            cnt.set(level, cnt.get(level) + 1);           
        }
                
        next(node.left, level + 1);
        next(node.right, level + 1);
    }
}
