package byteDance;

public class BinaryTreeMaximumPathSum {
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
            return 0 ;
        }
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));
        //以当前节点为路径的最大路径长度
        int curMaxPath = leftGain + node.val + rightGain;

        maxSum = Math.max(maxSum, curMaxPath);

        //当前节点在其他路径上的贡献
        return node.val + Math.max(leftGain, rightGain);
    }
}
