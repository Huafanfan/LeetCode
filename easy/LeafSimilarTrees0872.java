package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/10 12:55
 */
public class LeafSimilarTrees0872 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> lefts = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        String leftString = lefts.toString();
        lefts.clear();
        dfs(root2);
        return leftString.equals(lefts.toString());
    }

    public void dfs(TreeNode node){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            lefts.add(node.val);
        }
        else {
            dfs(node.left);
            dfs(node.right);
        }
    }

}
