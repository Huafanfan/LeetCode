package easy;

public class SecondMinimumNodeInABinaryTree0671 {
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
    int minNum;
    int secondNum;
    public int findSecondMinimumValue(TreeNode root) {
        minNum = root.val;
        secondNum = -1;
        dfs(root);
        return secondNum;
    }
    public void dfs(TreeNode node){
        if (node == null) {
            return;
        }
        if (secondNum != -1 && node.val >= secondNum) {
            return;
        }
        if (node.val > minNum) {
            secondNum = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
