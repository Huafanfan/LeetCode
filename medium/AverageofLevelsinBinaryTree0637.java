package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/14 11:33
 */
public class AverageofLevelsinBinaryTree0637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> floor = new ArrayDeque<>();
        floor.addLast(root);
        while (!floor.isEmpty()) {
            double sum = 0;
            int size = floor.size();
            for (int i=0; i<size; i++){
                TreeNode temp = floor.pollFirst();
                sum += temp.val;
                if (temp.left != null){
                    floor.addLast(temp.left);
                }
                if (temp.right != null){
                    floor.addLast(temp.right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }

    public List<Double> averageOfLevelsDFS(TreeNode root) {
        List<Integer> counts = new ArrayList<Integer>();
        List<Double> sums = new ArrayList<Double>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}
