package neetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/1 11:58
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            result.add(deque.getLast().val);
            while (size!=0){
                TreeNode tmp = deque.poll();
                size--;
                if (tmp.left!=null){
                    deque.add(tmp.left);
                }
                if (tmp.right!=null){
                    deque.add(tmp.right);
                }
            }
        }
        return result;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        // 从根节点开始访问，根节点深度是0
        dfs(root, 0);
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
