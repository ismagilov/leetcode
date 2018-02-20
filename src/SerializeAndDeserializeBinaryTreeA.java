/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * Using queue.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTreeA {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            
            if (cur == null)
                sb.append('X').append(',');
            else {
                sb.append(cur.val).append(',');
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
       
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(",");
        
        String rootData = nodes[0];
        if ("X".equals(rootData))
            return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(rootData));
        q.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = q.poll();
            if (!"X".equals(nodes[i])) {
                cur.left = new TreeNode(Integer.valueOf(nodes[i]));
                q.offer(cur.left);
            }
            i++;
            if (!"X".equals(nodes[i])) {
                cur.right = new TreeNode(Integer.valueOf(nodes[i]));
                q.offer(cur.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
