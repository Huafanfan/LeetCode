package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/12 11:19
 */
public class BinaryTreeRightSideView0199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> floor = new ArrayDeque<>();
        floor.add(root);
        while (!floor.isEmpty()){
            int size = floor.size();
            result.add(floor.getLast().val);
            while (size!=0){
                TreeNode tmp = floor.poll();
                size--;
                if (tmp.left!=null){
                    floor.add(tmp.left);
                }
                if (tmp.right!=null){
                    floor.add(tmp.right);
                }
            }
        }
        return result;
    }



    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {
            // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
