package com.huafanfan;

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
}
