package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/7 14:45
 */
public class SumRootToLeafNumbers0129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return 0;
        }
        Deque<Integer> path = new ArrayDeque<>();
        pathSum1(root,result,path);
        int sum = 0;
        for (List<Integer> tmp : result){
            int count = 0;
            for (Integer integer : tmp) {
                count = count * 10 + integer;
            }
            sum+=count;
        }
        return sum;
    }
    public void pathSum1(TreeNode node, List<List<Integer>> result, Deque<Integer> path) {
        if (node == null) {
            return;
        }
        path.addLast(node.val);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        pathSum1(node.left, result, path);
        pathSum1(node.right, result, path);
        path.removeLast();
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        if (root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return helper(root.left, temp) + helper(root.right, temp);
    }
}
