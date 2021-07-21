package byteDance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CheckCompletenessOfABinaryTree {
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

    int size = 0;
    int maxCode = 0;
    public boolean isCompleteTree(TreeNode root) {
        if (root == null){
            return true;
        }
        dfs(root, 1);
        return size == maxCode;
    }

    public void dfs(TreeNode node, int index){
        if (node == null){
            return;
        }
        size++;
        maxCode = Math.max(maxCode, index);
        dfs(node.left, 2 * index);
        dfs(node.right, 2 * index + 1);
    }
}
