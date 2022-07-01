package neetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/1 12:05
 */
public class CountGoodNodesInABinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    public int dfs(TreeNode node, int max){
        if (node == null){
            return 0;
        }
        int res = 0;
        if (node.val >= max){
            res = 1;
            max = node.val;
        }
        res += dfs(node.left, max);
        res += dfs(node.right, max);
        return res;
    }
}
