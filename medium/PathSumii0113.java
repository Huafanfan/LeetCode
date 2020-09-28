package medium;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/7 11:32
 */
public class PathSumii0113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSumDFS(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root,sum,result,path);
        return result;
    }
    public void dfs(TreeNode node, int sum, List<List<Integer>> result, Deque<Integer> path) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        path.addLast(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        dfs(node.left, sum, result, path);
        dfs(node.right, sum, result, path);
        path.removeLast();
    }

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSumBFS(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    //map用来存放各个节点的父节点
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            //从子开始便利到父节点停止
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }
}
