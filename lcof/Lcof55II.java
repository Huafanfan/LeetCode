package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 11:06
 */
public class Lcof55II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 5.11%
     * 6.66%
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean isBalancedLeft = isBalanced(root.left);
        boolean isBalancedRight = isBalanced(root.right);
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1){
            return false;
        }
        else {
            return isBalancedLeft && isBalancedRight;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 99.99%
     * 81.91%
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if(left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if(right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
