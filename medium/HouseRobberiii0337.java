package medium;

import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/25 15:39
 */
public class HouseRobberiii0337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxMoney = 0;

    /**
     * 通过，但是时间过慢
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return Math.max(rob(root, true),rob(root, false));
    }

    int rob(TreeNode root, boolean isRob){
        if (root==null){
            return 0;
        }
        if (isRob){
            return Math.max(rob(root.left, false) + rob(root.right, false),maxMoney);
        }
        else {
            return Math.max(Math.max(root.val + rob(root.left, true) + rob(root.right, true),maxMoney),Math.max(rob(root.left, false) + rob(root.right, false),maxMoney));
        }
    }

    public int robPro(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        //不偷
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
