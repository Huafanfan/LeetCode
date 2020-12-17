package lcof;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 13:50
 */
public class Lcof32II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 92.80%
     * 61.70%
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
            res.add(tempLists);
        }
        return res;
    }
}
