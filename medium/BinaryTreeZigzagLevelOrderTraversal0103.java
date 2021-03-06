package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/7 10:27
 */
public class BinaryTreeZigzagLevelOrderTraversal0103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        int turn = 0;
        while (!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode tmp = treeNodeQueue.poll();
                list.add(tmp.val);
                //if (turn==0){
                //    list.add(tmp.val);
                //}
                //else {
                //  reverse更快一点，list往头插，每次都是拷贝数组
                //    list.add(0,tmp.val);
                //}
                if (tmp.left!=null){
                    treeNodeQueue.add(tmp.left);
                }
                if (tmp.right!=null){
                    treeNodeQueue.add(tmp.right);
                }
            }
            if (turn==0){
                result.add(list);
            }
            else{
                Collections.reverse(list);
                result.add(list);
            }

            turn = (turn+1)%2;
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
