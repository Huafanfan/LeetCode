package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 14:51
 */
public class Lcof26 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 16.08%
     * 76.66%
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return ((A != null) && (B != null)) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        Lcof26 lcof26 = new Lcof26();
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(5);
        TreeNode node16 = new TreeNode(6);
        TreeNode node17 = new TreeNode(7);
        TreeNode node18 = new TreeNode(8);
        TreeNode node19 = new TreeNode(9);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;
        node13.left = node16;
        node13.right = node17;
        node14.left = node18;
        node14.right = node19;

        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(8);
        TreeNode node23 = new TreeNode(9);
        node21.left = node22;
        node21.right = node23;

        System.out.println(lcof26.isSubStructure(node11, node21));
    }
}
