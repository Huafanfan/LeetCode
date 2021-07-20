package byteDance;

public class FlattenBinaryTreeToLinkedList {
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

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null){
            TreeNode leftMostRight = cur.left;
            if (leftMostRight != null){
                while (leftMostRight.right != null){
                    leftMostRight = leftMostRight.right;
                }
                leftMostRight.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            else {
                cur = cur.right;
            }
        }
    }
}
