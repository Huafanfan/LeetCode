package medium;

import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/6 16:41
 */
public class ValidateBinarySearchTree0098 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return false;
        }
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long min,long max) {
        if (root == null){
            return true;
        }
        if (root.val>min&&root.val<max){
            //return isValidBST(root.left,min,Math.min(max, root.val))&&isValidBST(root.right,Math.max(min, root.val),max);
            return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
        }
        return false;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
