package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/28 14:20
 */
public class BinaryTreeMaximumPathSum0124 {
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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        int sum = left + right + node.val;
        maxSum = Math.max(maxSum , sum);
        return node.val + Math.max(left, right);
    }
}
