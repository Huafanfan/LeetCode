package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/22 10:46
 */
public class FindBottomLeftTreeValue0513 {
    public static class TreeNode {
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

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        int left = root.val;
        while (!deque.isEmpty()){
            int size = deque.size();
             left = deque.getFirst().val;
            for (int i=0; i<size; i++){
                TreeNode node = deque.pollFirst();
                if (node.left != null){
                    deque.offerLast(node.left);
                }
                if (node.right != null){
                    deque.offerLast(node.right);
                }
            }
        }
        return left;
    }
}
