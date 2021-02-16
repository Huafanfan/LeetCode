package microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/15 15:25
 */
public class SerializeAndDeserializeBinaryTree0297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        if (root == null){
            res.append("]");
            return res.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.append(root.val).append(",");
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null){
                queue.offer(node.left);
                res.append(node.left.val).append(",");
            }
            else {
                res.append("null").append(",");
            }

            if (node.right!=null){
                queue.offer(node.right);
                res.append(node.right.val).append(",");
            }
            else {
                res.append("null").append(",");
            }
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        if ("".equals(nodes[0])){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i=1; i<nodes.length;){
            TreeNode node = queue.poll();
            if (!"null".equals(nodes[i])){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;
                queue.offer(left);
            }
            else {
                node.left = null;
            }
            i++;
            if (!"null".equals(nodes[i])){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;
                queue.offer(right);
            }
            else {
                node.right = null;
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree0297 serializeAndDeserializeBinaryTree0297 = new SerializeAndDeserializeBinaryTree0297();
        System.out.println(serializeAndDeserializeBinaryTree0297.deserialize("[]"));
    }
}
