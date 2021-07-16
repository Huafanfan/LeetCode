package byteDance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);
        while (!nodeDeque.isEmpty()){
            int size = nodeDeque.size();
            List<Integer> levelNode = new ArrayList<>(size);
            for (int i=0; i<size; i++){
                TreeNode treeNode = nodeDeque.pollFirst();
                levelNode.add(treeNode.val);
                if (treeNode.left!=null){
                    nodeDeque.offerLast(treeNode.left);
                }
                if (treeNode.right!=null){
                    nodeDeque.offerLast(treeNode.right);
                }
                res.add(levelNode);
            }
        }
        return res;
    }

}
