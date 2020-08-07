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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root,sum,result,path);
        return result;
    }
    public void pathSum(TreeNode node, int sum, List<List<Integer>> result, Deque<Integer> path) {
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
        pathSum(node.left, sum, result, path);
        pathSum(node.right, sum, result, path);
        path.removeLast();
    }
}
