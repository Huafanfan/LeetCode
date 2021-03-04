package easy;

public class DiameterOfBinaryTree0543 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left != 0 || right != 0){
            max = Math.max(max, left + right);
        }
        return 1 + Math.max(left, right);
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
        DiameterOfBinaryTree0543 diameterOfBinaryTree0543 = new DiameterOfBinaryTree0543();
        System.out.println(diameterOfBinaryTree0543.diameterOfBinaryTree(node1));

    }
}
