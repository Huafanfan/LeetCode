package medium;

import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/11/15 22:47
 */
public class MinimumNumberOfOperationsToSortABinaryTreeByLevel2471 {
    public static class TreeNode {
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

    List<Integer> p = new ArrayList<>();

    public int find(int x){
        if (p.get(x) != x){
            p.set(x, find(p.get(x)));
        }
        return p.get(x);
    }

    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        List<Integer> w = new ArrayList<>();
        // 每层的起始位置
        List<Integer> ls = new ArrayList<>();
        while (!q.isEmpty()){
            int sz = q.size();
            ls.add(w.size());
            for (int k=0; k<sz; k++){
                TreeNode t = q.pollFirst();
                w.add(t.val);
                if (t.left != null){
                    q.add(t.left);
                }
                if (t.right != null){
                    q.add(t.right);
                }
            }
        }
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i=0; i<w.size(); i++){
            pos.put(w.get(i), i);
            p.add(i);
        }

        // 最后一层，方便处理
        ls.add(w.size());
        int[] ww = new int[w.size()];
        for (int i=0; i<w.size(); i++){
            ww[i] = w.get(i);
        }

        for (int i=0; i+1 < ls.size(); i++){
            Arrays.sort(ww, ls.get(i), ls.get(i+1));
        }
        int cnt = ww.length;
        for (int i=0; i<ww.length; i++){
            int a = find(i), b = find(pos.get(ww[i]));
            if (a != b){
                p.set(a, b);
                cnt--;
            }
        }
        return ww.length - cnt;
    }
}
