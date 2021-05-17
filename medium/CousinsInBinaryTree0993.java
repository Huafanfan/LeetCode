package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/17 15:38
 */
public class CousinsInBinaryTree0993 {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.addLast(root);
        while (true){
            int size = nodeDeque.size();
            boolean ifFindX = false;
            boolean ifFindY = false;
            for (int i=0; i<size; i++){
                TreeNode cur = nodeDeque.removeFirst();
                if (cur.left!=null && cur.right!=null){
                    if ((cur.left.val == x || cur.left.val == y) && (cur.right.val == x || cur.right.val == y)){
                        return false;
                    }
                    else if(cur.left.val == x || cur.right.val == x){
                        ifFindX = true;
                    }
                    else if(cur.left.val == y || cur.right.val == y){
                        ifFindY = true;
                    }
                    nodeDeque.addLast(cur.left);
                    nodeDeque.addLast(cur.right);
                }
                else if(cur.left!=null){
                    if (cur.left.val == x){
                        ifFindX = true;
                    }
                    else if (cur.left.val == y){
                        ifFindY = true;
                    }
                    nodeDeque.addLast(cur.left);
                }
                else if(cur.right!=null){
                    if (cur.right.val == x){
                        ifFindX = true;
                    }
                    else if (cur.right.val == y){
                        ifFindY = true;
                    }
                    nodeDeque.addLast(cur.right);
                }
            }
            if (ifFindX && ifFindY){
                return true;
            }
            else if (ifFindX || ifFindY){
                return false;
            }
        }
    }

    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins2(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }

        // 如果两个节点都找到了，就可以提前退出遍历
        // 即使不提前退出，对最坏情况下的时间复杂度也不会有影响
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);

        if (xFound && yFound) {
            return;
        }

        dfs(node.right, depth + 1, node);
    }

    public static void main(String[] args) {
        CousinsInBinaryTree0993 cousinsInBinaryTree0993 = new CousinsInBinaryTree0993();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode8;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode5;
        treeNode3.right = treeNode7;
        System.out.println(cousinsInBinaryTree0993.isCousins(treeNode1, 5, 8));
    }
}
