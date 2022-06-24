package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/24 11:03
 */
public class FindLargestValueInEachTreeRow0515 {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            for (int i=0; i<size; i++){
                TreeNode node = deque.pollFirst();
                max = Math.max(max, node.val);
                if (node.left != null){
                    deque.offerLast(node.left);
                }
                if (node.right != null){
                    deque.offerLast(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
