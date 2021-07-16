package byteDance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementInABst {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    public void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 迭代的中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (true){
            while (root != null){
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (--k == 0){
                return root.val;
            }
            root = root.right;
        }
    }
}
