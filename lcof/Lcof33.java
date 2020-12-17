package lcof;

import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 14:15
 */
public class Lcof33 {
    /**
     * 100.00%
     * 97.00%
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length-1);
    }
    public boolean dfs(int[] postorder, int left, int right){
        if (left >= right){
            return true;
        }
        else {
            int root = postorder[right];
            int i = left;
            for (; i<=right-1; i++){
                if (postorder[i] > root){
                    break;
                }
            }
            for (int j = i; j<=right-1; j++){
                if (postorder[j] < root){
                    return false;
                }
            }
            return dfs(postorder, left, i-1) & dfs(postorder, i, right-1);
        }
    }

    /**
     * 22.62%
     * 53.39%
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }


    public static void main(String[] args) {
        Lcof33 lcof33 = new Lcof33();
        int[] postorder = new int[]{1,3,2,6,5};
        System.out.println(lcof33.verifyPostorder2(postorder));
    }
}
