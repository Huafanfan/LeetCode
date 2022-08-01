package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/23 09:34
 */
public class MergeTwoBinaryTrees0617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTreesDfs(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTreesDfs(t1.left, t2.left);
        root.right = mergeTreesDfs(t1.right, t2.right);
        return root;
    }

    public TreeNode mergeTreesBfs(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue1 = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue2 = new LinkedList<>();
        treeNodeQueue.add(root);
        treeNodeQueue1.add(t1);
        treeNodeQueue2.add(t2);
        //如果两个原始二叉树的左子节点有一个为空，即有一个原始二叉树的左子树为空，则合并后的二叉树的左子树即为另一个原始二叉树的左子树，此时也不需要对非空左子树继续遍历，因此不需要将左子节点加入队列。
        while (!treeNodeQueue1.isEmpty()&&!treeNodeQueue2.isEmpty()){
            TreeNode node = treeNodeQueue.poll();
            TreeNode node1 = treeNodeQueue1.poll();
            TreeNode node2 = treeNodeQueue2.poll();
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if (left1!=null || left2 != null){
                if (left1!=null && left2 != null){
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    treeNodeQueue.add(left);
                    treeNodeQueue1.add(left1);
                    treeNodeQueue2.add(left2);
                }else if (left1 != null){
                    node.left = left1;
                }else if (left2 != null){
                    node.left = left2;
                }
            }
            if (right1!=null || right2 != null){
                if (right1!=null && right2 != null){
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    treeNodeQueue.add(right);
                    treeNodeQueue1.add(right1);
                    treeNodeQueue2.add(right2);
                }else if (right1 != null){
                    node.right = right1;
                }else if (right2 != null){
                    node.right = right2;
                }
            }
        }
        return root;
    }
}
