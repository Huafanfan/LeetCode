package neetcode.trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 11:37
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    List<String> res = new ArrayList<>();
    public String serialize(TreeNode root) {
        dfs(root);
        return res.toString();
    }

    public void dfs(TreeNode node){
        if (node == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    int index;
    String[] vals;
    public TreeNode deserialize(String data) {
        vals = data.substring(1, data.length() - 1).split(", ");
        return dfs();
    }
    public TreeNode dfs(){
        if ("N".equals(vals[index])){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[index++]));
        node.left = dfs();
        node.right = dfs();
        return node;
    }
}
