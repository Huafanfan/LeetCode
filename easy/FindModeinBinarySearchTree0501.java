package easy;

import java.util.ArrayList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/22 14:43
 */
public class FindModeinBinarySearchTree0501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 深度便利会使用到栈，所以有额外的空间
     */
    int preVal=0,curTimes=0,maxTimes=0;
    ArrayList<Integer> arrayList = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversals(root);
        int size = arrayList.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = arrayList.get(i);
        }
        return ans;
    }
    public void traversals(TreeNode root){
        if (root!=null){
            traversals(root.left);
            if(root.val==preVal){
                curTimes++;
            }
            else{
                curTimes=1;
                preVal=root.val;
            }
            if(curTimes==maxTimes){
                arrayList.add(root.val);
            }
            else if(curTimes>maxTimes){
                arrayList.clear();
                arrayList.add(root.val);
                maxTimes=curTimes;
            }
            traversals(root.right);
        }
    }


    /**
     * 我们需要用一种巧妙地方法可以在 O(1) 的空间下，遍历完左子树可以再回到当前节点。
     * 我们希望当前的节点在遍历完当前点的前驱之后被遍历，我们可以考虑修改它的前驱节点的 right 指针。
     * 当前节点的前驱节点的 right 指针可能本来就指向当前节点（前驱是当前节点的父节点），也可能是当前节点左子树最右下的节点。
     * 如果是后者，我们希望遍历完这个前驱节点之后再回到当前节点，可以将它的 \rm rightright 指针指向当前节点。
     *
     * Morris 中序遍历的一个重要步骤就是寻找当前节点的前驱节点，并且 Morris 中序遍历寻找下一个点始终是通过转移到 right 指针指向的位置来完成的。
     *
     */
    int base, count, maxCount;
    ArrayList<Integer> answer = new ArrayList<>();
    public int[] findModeMorris(TreeNode root) {
        TreeNode current = root;
        TreeNode pre;
        while (current!=null){
            if (current.left == null){
                update(current.val);
                current = current.right;
                continue;
            }
            pre = current.left;
            while (pre.right != null && pre.right!=current){
                pre = pre.right;
            }
            if (pre.right==null){
                pre.right = current;
                current = current.left;
            }else {
                pre.right = null;
                update(current.val);
                current = current.right;
            }
        }
        int[] ans = new int[answer.size()];
        for (int i=0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
    public void update(int number){
        if (number == base){
            count++;
        }else {
            base = number;
            count = 1;
        }
        if (count == maxCount){
            answer.add(base);
        }
        if (count > maxCount){
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
