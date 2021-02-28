package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/28 13:51
 */
public class FlattenBinaryTreeToLinkedList0114 {
    public static class TreeNode {
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
        rightToLeft(root);
        TreeNode cur = root;
        while (cur!=null){
            if (cur.left != null){
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    public void rightToLeft(TreeNode node){
        if (node == null){
            return;
        }
        if (node.left != null){
            TreeNode lastNode = node.left;
            while (lastNode.right != null){
                lastNode = lastNode.right;
            }
            lastNode.right = node.right;
            rightToLeft(node.left);
        }
        else if (node.right != null){
            rightToLeft(node.right);
        }
    }

    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList0114 flattenBinaryTreeToLinkedList0114 = new FlattenBinaryTreeToLinkedList0114();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        flattenBinaryTreeToLinkedList0114.flatten(node1);
        System.out.println(node1);
    }
}
