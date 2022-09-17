package acwing.searchgraphtheory.dfs.acwing846;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/17 4:46 PM
 */
public class Main {
    static int N = 100010, M = N * 2;
    static int n;
    /**
     * h : 邻接表法，h表示所有的点的开头。有多少个不同的点，h就有多长，所以h最大等于N
     * h[a] 指向a连接的节点的idx
     */
    static int[] h = new int[N];
    static boolean[] st = new boolean[N];
    static int idx;
    /**
     * e : 表示第idx个点是多少，idx从0开始递增，因为是无向图，最多M
     */
    static int[] e = new int[M];
    /**
     * ne : 表示当前idx点的下一个点的idx是多少，
     */
    static int[] ne = new int[M];

    static int ans = N;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        Arrays.fill(h, -1);
        for (int i=0; i<n-1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        // 这里从1开始是因为本来是指一个无向图，但是题目说是一颗树，根节点是1
        dfs(1);
        System.out.println(ans);
    }

    /**
     * 将b链接到head[a] 下面
     * @param a head[a]
     * @param b 真正的点
     */
    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }
    /**
     *
     * @param u 以u为根的子树中点的数量
     * @return
     */
    static int dfs(int u){
        // 标记被搜过
        st[u] = true;
        int sum = 1, res = 0;
        for (int idx = h[u]; idx != -1; idx = ne[idx]){
            int j = e[idx];
            if (!st[j]){
                int s = dfs(j);
                res = Math.max(res, s);
                sum += s;
            }
        }
        // 这里的sum 是点u以及其儿子的所有的和，用n减去后，就是剩下部分的连同数
        res = Math.max(res, n - sum);
        ans = Math.min(ans, res);
        return sum;
    }
}
