package lcof;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 13:24
 */
public class Lcof32I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 99.73%
     * 80.31%
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()){
            TreeNode temp = deque.pollFirst();
            if (temp == null){
                break;
            }
            ans.add(temp.val);
            if (temp.left!=null){
                deque.offerLast(temp.left);
            }
            if (temp.right!=null){
                deque.offerLast(temp.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i=0; i<res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
