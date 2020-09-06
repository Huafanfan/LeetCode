package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/10 11:10
 */
public class BinaryTreePreorderTraversal0144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        //Stack比Deque慢
        //Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.addLast(root);
        while (!treeNodes.isEmpty()){
            TreeNode tmp = treeNodes.pollLast();
            result.add(tmp.val);
            if (tmp.right!=null){
                treeNodes.addLast(tmp.right);
            }
            if (tmp.left!=null){
                treeNodes.addLast(tmp.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                output.add(node.val);
                node = node.right;
            }
            else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                }
                else{
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }
}
