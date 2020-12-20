package lcof;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 10:53
 */
public class Lcof55I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 20.94%
     * 81.54%
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offerLast(root);
        int depth = 0;
        while (!treeNodeDeque.isEmpty()){
            int length = treeNodeDeque.size();
            for (int i=0; i<length; i++){
                TreeNode tmp = treeNodeDeque.pollFirst();
                if (tmp.left!=null){
                    treeNodeDeque.offerLast(tmp.left);
                }
                if (tmp.right!=null){
                    treeNodeDeque.offerLast(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 100.00%
     * 70.73%
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

}
