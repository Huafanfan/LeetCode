package acwing.algorithmbasic.dynamicprogramming.treedp.acwing285;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/22 21:07
 */
public class Main {
    static int N = 6010;
    static int n;
    static int[] w = new int[N];
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx;
    static boolean[] st = new boolean[N];

    static int[][] f = new int[N][2];

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u){
        //最坏程度就是那个点不选，就是快乐指数为0
        //f[u][0] = 0;
        f[u][1] = w[u];
        for (int index=h[u]; index!=-1; index = ne[index]){
            int j = e[index];
            dfs(j);
            f[u][0] += Math.max(f[j][0], f[j][1]);
            f[u][1] += f[j][0];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        for (int i=1; i<=n; i++){
            w[i] = in.nextInt();
        }
        Arrays.fill(h, -1);
        for (int i=0; i<n-1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            add(b, a);
            st[a] = true;
        }

        int root = 1;
        while (st[root]){
            root++;
        }

        dfs(root);

        System.out.println(Math.max(f[root][0], f[root][1]));
    }
}
