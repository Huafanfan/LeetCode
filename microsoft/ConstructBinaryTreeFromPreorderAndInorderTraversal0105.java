package microsoft;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal0105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i=0; i<len; i++){
            inMap.put(inorder[i], i);
        }
        return recrusion(preorder, 0, len - 1, inorder, 0, len - 1, inMap);
    }

    public TreeNode recrusion(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, Map<Integer, Integer> inMap){
        if (pLeft > pRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        int index = inMap.get(preorder[pLeft]);
        int leftSize = index - iLeft;
        root.left = recrusion(preorder, pLeft + 1, pLeft + leftSize, inorder, iLeft, index - 1, inMap);
        root.right = recrusion(preorder, pLeft + leftSize + 1, pRight, inorder, index + 1, iRight , inMap);
        return root;
    }
}
