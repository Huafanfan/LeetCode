package hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/24 12:22
 */
public class MaximumXorWithAnElementFromArray1707 {
    /**
     * 超时
     * @param nums
     * @param queries
     * @return
     */
    //public int[] maximizeXor(int[] nums, int[][] queries) {
    //    Arrays.sort(nums);
    //    int[] res = new int[queries.length];
    //    for (int i=0; i<queries.length; i++){
    //        if (nums[0] > queries[i][1]){
    //            res[i] = -1;
    //        }
    //        else {
    //            int max = Integer.MIN_VALUE;
    //            for (int num : nums) {
    //                if (num <= queries[i][1]) {
    //                    max = Math.max(max, queries[i][0] ^ num);
    //                } else {
    //                    break;
    //                }
    //            }
    //            res[i] = max;
    //        }
    //    }
    //    return res;
    //}

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int numQ = queries.length;
        int[][] newQueries = new int[numQ][3];
        for (int i = 0; i < numQ; ++i) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            @Override
            public int compare(int[] query1, int[] query2) {
                return query1[1] - query2[1];
            }
        });

        int[] ans = new int[numQ];
        Trie trie = new Trie();
        int idx = 0, n = nums.length;
        for (int[] query : newQueries) {
            int x = query[0], m = query[1], qid = query[2];
            while (idx < n && nums[idx] <= m) {
                trie.insert(nums[idx]);
                ++idx;
            }
            // 字典树为空
            if (idx == 0) {
                ans[qid] = -1;
            } else {
                ans[qid] = trie.getMax(x);
            }
        }
        return ans;
    }

    //public int[] maximizeXor(int[] nums, int[][] queries) {
    //    Trie trie = new Trie();
    //    for (int val : nums) {
    //        trie.insert(val);
    //    }
    //    int numQ = queries.length;
    //    int[] ans = new int[numQ];
    //    for (int i = 0; i < numQ; ++i) {
    //        ans[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
    //    }
    //    return ans;
    //}
}
class Trie {
    static final int L = 30;
    Trie[] child = new Trie[2];

    public void insert(int val){
        Trie node = this;
        for (int i = L-1; i>=0; i--){
            //从高位到低位
            int bit = (val >> i) & 1;
            if (node.child[bit] == null){
                node.child[bit] = new Trie();
            }
            node = node.child[bit];
        }
    }
    public int getMax(int val){
        Trie node = this;
        int ans = 0;
        for (int i = L-1; i>=0; i--){
            int bit = (val >> i) & 1;
            //这里是寻找哪个节点异或完后为1，如果没有就进入子节点
            if (node.child[bit ^ 1] != null){
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node.child[bit];
        }
        return ans;
    }
}

//class Trie {
//    static final int L = 30;
//    Trie[] children = new Trie[2];
//    int min = Integer.MAX_VALUE;
//
//    public void insert(int val) {
//        Trie node = this;
//        node.min = Math.min(node.min, val);
//        for (int i = L - 1; i >= 0; --i) {
//            int bit = (val >> i) & 1;
//            if (node.children[bit] == null) {
//                node.children[bit] = new Trie();
//            }
//            node = node.children[bit];
//            node.min = Math.min(node.min, val);
//        }
//    }
//
//    public int getMaxXorWithLimit(int val, int limit) {
//        Trie node = this;
//        if (node.min > limit) {
//            return -1;
//        }
//        int ans = 0;
//        for (int i = L - 1; i >= 0; --i) {
//            int bit = (val >> i) & 1;
//            if (node.children[bit ^ 1] != null && node.children[bit ^ 1].min <= limit) {
//                ans |= 1 << i;
//                bit ^= 1;
//            }
//            node = node.children[bit];
//        }
//        return ans;
//    }
//}
