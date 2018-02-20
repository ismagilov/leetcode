/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * Using recursion.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTreeB {
   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder out = new StringBuilder();
        
        serialize(root, out);
        
        return out.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder out) {
        if (null == root) {
            out.append('X').append(',');
            return;
        }
        
        out.append(root.val).append(',');
        serialize(root.left, out);
        serialize(root.right, out);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> nodes) {
        String cur = nodes.poll();
        if ("X".equals(cur))
            return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
