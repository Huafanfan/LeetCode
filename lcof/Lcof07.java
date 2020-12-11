package lcof;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/11 15:49
 */
public class Lcof07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 68.81%
     * 58.23%
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length<1){
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i=0; i<length; i++){
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length-1, inorder, 0, length-1, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd){
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart != preorderEnd) {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            root.left = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            root.right = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
        }
        return root;
    }

    /**
     * 97.81%
     * 85.69%
     * 迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Lcof07 lcof07 = new Lcof07();
        int[] preorder = new int[]{3,9,8,5,4,10,20,15,7};
        int[] inorder = new int[]{4,5,8,10,9,3,15,20,7};
        System.out.println(lcof07.buildTree2(preorder, inorder).val);
    }

}
