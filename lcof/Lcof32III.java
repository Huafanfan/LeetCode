package lcof;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 14:01
 */
public class Lcof32III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 28.44%
     * 76.35%
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int length = deque.size();
            List<Integer> tempLists = new ArrayList<>();
            for (int i=0; i<length; i++){
                TreeNode temp = deque.pollFirst();
                tempLists.add(temp.val);
                if (temp.left!=null){
                    deque.offerLast(temp.left);
                }
                if (temp.right!=null){
                    deque.offerLast(temp.right);
                }
            }
            if ((res.size() & 1) == 0){
                Collections.reverse(tempLists);
            }
            res.add(tempLists);
        }
        return res;
    }
}
