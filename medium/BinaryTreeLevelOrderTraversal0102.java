package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/7 9:52
 */
public class BinaryTreeLevelOrderTraversal0102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode tmp = treeNodeQueue.poll();
                list.add(tmp.val);
                if (tmp.left!=null){
                    treeNodeQueue.add(tmp.left);
                }
                if (tmp.right!=null){
                    treeNodeQueue.add(tmp.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
