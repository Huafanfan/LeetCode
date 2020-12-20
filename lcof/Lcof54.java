package lcof;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 10:23
 */
public class Lcof54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<TreeNode> list;

    /**
     * 100.00%
     * 92.51%
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        list = new ArrayList<>();
        unInOrderTraversal(root, k, list);
        return list.get(k).val;
    }

    public void unInOrderTraversal(TreeNode root , int k, List<TreeNode> list){
        if (root == null){
            return;
        }
        unInOrderTraversal(root.right, k, list);
        if (list.size() == k){
            return;
        }
        list.add(root);

        unInOrderTraversal(root.left, k, list);
    }
}
