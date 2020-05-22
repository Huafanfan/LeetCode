package com.huafanfan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/21 09:29
 */
public class InvertBinaryTree0226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *  迭代，使用栈，层次遍历
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode currentNode = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            currentNode = stack.pop();
            TreeNode temp = currentNode.left;
            currentNode.left=currentNode.right;
            currentNode.right=temp;
            if (currentNode.right!=null){
                stack.push(currentNode.right);
            }
            if (currentNode.left!=null){
                stack.push(currentNode.left);
            }
        }
        return root;
    }

    /**
     * 迭代 使用队列，层次遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }

    /**
     * 递归 后续遍历
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree3(root.right);
        TreeNode left = invertTree3(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 递归 先续遍历
     * @param root
     * @return
     */
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree4(root.left);
        root.left = invertTree4(rightTree);
        return root;
    }

    /**
     * 递归 中序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree5(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree5(root.left);
        TreeNode rightNode= root.right;
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree5(root.left);
        return root;
    }
}
