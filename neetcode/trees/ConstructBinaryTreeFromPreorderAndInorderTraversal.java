package neetcode.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 10:03
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recursion(preorder, inorder, 0,inorder.length-1, 0, inorder.length-1, map);
    }
    public TreeNode recursion(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight,  Map<Integer, Integer> map){
        if (preLeft > preRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(preorder[preLeft]);
        int leftLength = index - inLeft;
        root.left = recursion(preorder, inorder, preLeft + 1, preLeft + leftLength, inLeft, index - 1, map);
        root.right = recursion(preorder, inorder, preLeft + leftLength + 1, preRight, index + 1, inRight, map);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = c.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
