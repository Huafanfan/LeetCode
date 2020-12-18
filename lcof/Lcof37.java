package lcof;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 10:42
 */
public class Lcof37 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root==null){
            return list.toString();
        }
        deque.offerLast(root);
        list.add(root.val);
        while (!deque.isEmpty()){
            TreeNode temp = deque.pollFirst();
            if (temp.left!=null){
                list.add(temp.left.val);
                deque.offerLast(temp.left);
            }
            else {
                list.add(null);
            }

            if (temp.right!=null){
                list.add(temp.right.val);
                deque.offerLast(temp.right);
            }
            else {
                list.add(null);
            }
        }
        while (list.get(list.size()-1) == null){
            list.remove(list.size()-1);
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.substring(1,data.length()-1).split(", ");
        int index = 0;
        if ("null".equals(datas[index]) || "".equals(datas[index])){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(datas[index++]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            if (!"null".equals(datas[index])){
                TreeNode left = new TreeNode(Integer.parseInt(datas[index]));
                cur.left = left;
                deque.offerLast(left);
            }
            index++;
            if (!"null".equals(datas[index])){
                TreeNode right = new TreeNode(Integer.parseInt(datas[index]));
                cur.right = right;
                deque.offerLast(right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Lcof37 lcof37 = new Lcof37();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(lcof37.deserialize(lcof37.serialize(null)));
    }
}
