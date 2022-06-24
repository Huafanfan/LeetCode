package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/24 11:10
 */
public class DiameterOfABinaryTree {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        max = Math.max(max, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        DiameterOfABinaryTree d = new DiameterOfABinaryTree();
        System.out.println(d.diameterOfBinaryTree(node1));
    }
}
