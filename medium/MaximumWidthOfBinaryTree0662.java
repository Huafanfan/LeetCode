package medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumWidthOfBinaryTree0662 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Node{
        TreeNode treeNode;
        int index;
        Node(TreeNode t, int i){
            treeNode = t;
            index = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.add(new Node(root, 1));
        int maxWidth = 1;
        while (!nodeDeque.isEmpty()){
            maxWidth = Math.max(maxWidth, (nodeDeque.getLast().index - nodeDeque.getFirst().index) + 1);
            int size = nodeDeque.size();
            for (int i=0; i<size; i++){
                Node node = nodeDeque.pollFirst();
                if (node.treeNode.left != null){
                    nodeDeque.add(new Node(node.treeNode.left, node.index * 2));
                }
                if (node.treeNode.right != null){
                    nodeDeque.add(new Node(node.treeNode.right, node.index * 2 + 1));
                }
            }
        }
        return maxWidth;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int ans;
    public int widthOfBinaryTree2(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }
    void dfs(TreeNode root, int u, int depth) {
        if (root == null) {
            return ;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, u);
        }
        ans = Math.max(ans, u - map.get(depth) + 1);
//        u = u - map.get(depth) + 1;
        dfs(root.left, u << 1, depth + 1);
        dfs(root.right, u << 1 | 1, depth + 1);
    }
}
