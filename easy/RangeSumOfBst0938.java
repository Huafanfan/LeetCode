package easy;

public class RangeSumOfBst0938 {
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
    int res = 0;
    int LOW;
    int HIGHT;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.LOW = low;
        this.HIGHT = high;
        Preorder(root);
        return res;
    }

    private void Preorder(TreeNode node){
        if (node == null){
            return;
        }
        if (node.val >= LOW && node.val <= HIGHT){
            res += node.val;
            Preorder(node.left);
            Preorder(node.right);
        }
        else {
            if (node.val < LOW){
                Preorder(node.right);
            }
            else {
                Preorder(node.left);
            }
        }
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST2(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST2(root.right, low, high);
        }
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
    }
}
