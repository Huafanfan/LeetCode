package medium;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/29 09:28
 */
public class BinaryTreePostorderTraversal0145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev){
                res.add(root.val);
                prev = root;
                root = null;
            }
            else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * Morris 遍历
     * 不如中序遍历清晰，最后便利完的结果剩余从根节点开始沿着右子树一直向下的节点。所以在最后需要 addPath(res, root)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        TreeNode curr = root, pre = null;
        while (curr != null){
            pre = curr.left;
            if (pre != null){
                while (pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                    continue;
                }
                else {
                    pre.right = null;
                    addPath(res, curr.left);
                }
            }
            curr = curr.right;
        }
        addPath(res, root);
        return res;
    }
    public void addPath(List<Integer> res, TreeNode root){
        List<Integer> tmp = new ArrayList<>();
        while (root != null){
            tmp.add(root.val);
            root = root.right;
        }
        for (int i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }
}
