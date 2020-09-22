package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/22 10:33
 */
public class ConvertBsttoGreaterTree0538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;

    /**
     * 反向中序便利
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
