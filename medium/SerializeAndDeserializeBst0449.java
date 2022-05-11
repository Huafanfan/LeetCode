package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/11 10:41
 */
public class SerializeAndDeserializeBst0449 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        return root.val + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 1){
            return null;
        }
        int value = data.charAt(0) - '0';
        TreeNode cur = new TreeNode(value);
        if (data.length() == 1){
            return cur;
        }
        int index = -1;
        for (int i=1; i<data.length(); i++){
            if (data.charAt(i) > data.charAt(0)){
                index = i;
                break;
            }
        }
        if (index == -1){
            cur.left = deserialize(data.substring(1));
            cur.right = null;
        }
        else {
            cur.left = deserialize(data.substring(1).substring(0, index-1));
            cur.right = deserialize(data.substring(1).substring(index-1));
        }

        return cur;
    }

    public String serialize2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        dfs1(root, list);
        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            if (i != n - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
    void dfs1(TreeNode root, List<String> list) {
        if (root == null) {
            return ;
        }
        list.add(String.valueOf(root.val));
        dfs1(root.left, list);
        dfs1(root.right, list);
    }
    public TreeNode deserialize2(String s) {
        if (s == null) {
            return null;
        }
        String[] ss = s.split(",");
        return dfs2(0, ss.length - 1, ss);
    }
    TreeNode dfs2(int l, int r, String[] ss) {
        if (l > r) {
            return null;
        }
        int j = l + 1, t = Integer.parseInt(ss[l]);
        TreeNode ans = new TreeNode(t);
        while (j <= r && Integer.parseInt(ss[j]) <= t) {
            j++;
        }
        ans.left = dfs2(l + 1, j - 1, ss);
        ans.right = dfs2(j, r, ss);
        return ans;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBst0449 serializeAndDeserializeBst0449 = new SerializeAndDeserializeBst0449();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        //TreeNode node3 = new TreeNode(3);
        //TreeNode node4 = new TreeNode(4);
        //TreeNode node5 = new TreeNode(5);
        //node3.left = node1;
        //node1.right = node2;
        //node3.right = node4;
        //node4.right = node5;
        node2.left = node1;


        String s1 = serializeAndDeserializeBst0449.serialize(node2);
        System.out.println(s1);
        TreeNode newNode1 = serializeAndDeserializeBst0449.deserialize(s1);

        String s2 = serializeAndDeserializeBst0449.serialize2(node2);
        System.out.println(s2);
        TreeNode newNode2 = serializeAndDeserializeBst0449.deserialize2(s2);

        System.out.println("aaaa");

    }
}
