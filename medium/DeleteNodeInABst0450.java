package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/2 10:42
 */
public class DeleteNodeInABst0450 {
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

    //public TreeNode deleteNode(TreeNode root, int key) {
    //    if (root == null){
    //        return null;
    //    }
    //    if (root.val == key){
    //        if (root.right != null){
    //            TreeNode cur = root.right;
    //            while (cur.left != null){
    //                cur = cur.left;
    //            }
    //            cur.left = root.left;
    //            return root.right;
    //        } else {
    //            return root.left;
    //        }
    //    }
    //    TreeNode parent = null;
    //    TreeNode cur = root;
    //    while (cur != null && cur.val != key){
    //        if (cur.val < key){
    //            parent = cur;
    //            cur = cur.right;
    //        } else {
    //            parent = cur;
    //            cur = cur.left;
    //        }
    //    }
    //    if (cur == null){
    //        return root;
    //    } else {
    //        if (cur.val < parent.val){
    //            if (cur.right != null){
    //                TreeNode next = cur.right;
    //                while (next.left != null){
    //                    next = next.left;
    //                }
    //                next.left = cur.left;
    //                parent.left = next;
    //            } else {
    //                parent.left = cur.left;
    //            }
    //        } else {
    //            if (cur.left == null){
    //                parent.right = cur.right;
    //            } else if (cur.right == null){
    //                parent.right = cur.left;
    //            } else {
    //                TreeNode next = cur.right;
    //                while (next.left != null){
    //                    next = next.left;
    //                }
    //                next.left = cur.left;
    //                parent.right = cur.right;
    //            }
    //        }
    //    }
    //    return root;
    //}

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.right == null) {
            return root.left;
        }
        if (root.left == null) {
            return root.right;
        }
        TreeNode successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        root.right = deleteNode(root.right, successor.val);
        successor.right = root.right;
        successor.left = root.left;
        return successor;
    }
}
