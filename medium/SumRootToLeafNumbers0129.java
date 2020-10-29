package medium;

import java.util.*;

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
    public int sumNumbersDfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return 0;
        }
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root,result,path);
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
    public void pathSum(TreeNode node, List<List<Integer>> result, Deque<Integer> path) {
        if (node == null) {
            return;
        }
        path.addLast(node.val);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        pathSum(node.left, result, path);
        pathSum(node.right, result, path);
        path.removeLast();
    }

    public int sumNumbersDFS(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum){
        if (root == null) {
            return 0;
        }
        int temp = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return dfs(root.left, temp) + dfs(root.right, temp);
    }

    public int sumNumbersBFS(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();
        nodes.offer(root);
        nums.offer(root.val);
        int sum = 0;
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int num = nums.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null){
                sum += num;
            }
            else {
                if (left != null){
                    nodes.offer(left);
                    nums.offer(num * 10 + left.val);
                }
                if (right != null){
                    nodes.offer(right);
                    nums.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
