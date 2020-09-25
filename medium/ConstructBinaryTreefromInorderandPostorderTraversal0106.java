package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/25 09:21
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal0106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     */

    /**
     * 为了高效查找根节点元素在中序遍历数组中的下标，我们选择创建哈希表来存储中序序列，即建立一个（元素，下标）键值对的哈希表
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(postorder.length-1, 0, postorder.length-1, postorder);
    }

    TreeNode build(int index, int left, int rifht, int[] postorder){
        if (left > rifht){
            return null;
        }
        TreeNode node = new TreeNode(postorder[index]);
        int mid = map.get(postorder[index]);
        node.left = build(index - (rifht -mid) - 1, left, mid-1, postorder);
        node.right = build(index - 1, mid+1, rifht, postorder);
        return node;
    }


    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树 这里必须是先右后左，先把右子树构建完成后，post_idx的值就刚好为左子树的。
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{4, 9, 6, 3, 15, 20, 7};
        int[] postorder = new int[]{4, 6, 9, 15, 7, 20, 3};
        ConstructBinaryTreefromInorderandPostorderTraversal0106 function = new ConstructBinaryTreefromInorderandPostorderTraversal0106();
        function.buildTree1(inorder, postorder);
    }
}
