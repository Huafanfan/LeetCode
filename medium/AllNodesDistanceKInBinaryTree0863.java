package medium;

import java.util.*;

public class AllNodesDistanceKInBinaryTree0863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        findDistanceK(target, k, null);
        return res;
    }

    public void  findParent(TreeNode node){
        if (node == null){
            return;
        }
        if (node.left != null){
            map.put(node.left, node);
            findParent(node.left);
        }
        if (node.right != null){
            map.put(node.right, node);
            findParent(node.right);
        }
    }

    public void findDistanceK(TreeNode node, int k, TreeNode from){
        if (k == 0){
            res.add(node.val);
            return;
        }
        if (node.left != null && node.left != from){
            findDistanceK(node.left, k-1, node);
        }
        if (node.right != null && node.right != from){
            findDistanceK(node.right, k-1, from);
        }
        TreeNode parent = map.get(node);
        if (parent != null && parent != from){
            findDistanceK(parent, k-1, node);
        }
    }

    int N = 1010, M = N * 2;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    boolean[] vis = new boolean[N];
    public List<Integer> distanceK2(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(t.val);
        vis[t.val] = true;
        while (!d.isEmpty() && k >= 0) {
            int size = d.size();
            while (size-- > 0) {
                int poll = d.pollFirst();
                if (k == 0) {
                    ans.add(poll);
                    continue;
                }
                for (int i = he[poll]; i != -1 ; i = ne[i]) {
                    int j = e[i];
                    if (!vis[j]) {
                        d.addLast(j);
                        vis[j] = true;
                    }
                }
            }
            k--;
        }
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}
