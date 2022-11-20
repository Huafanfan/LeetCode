package acwing.algorithmimprovement.dp.backpack.acwing10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/20 15:22
 */
public class Main {
    static int N = 110;
    static int n,m;
    static int[] v = new int[N];
    static int[] w = new int[N];

    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx;

    static int[][] f = new int[N][N];

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    static void dfs(int u){
        // 循环物品组
        for (int i=h[u]; i!=-1; i=ne[i]){
            int son = e[i];
            dfs(son);

            // 分组背包
            // 循环体积
            for (int j=m-v[u]; j>=0; j--){
                // 循环决策
                for (int k=0; k<=j; k++){
                    f[u][j] = Math.max(f[u][j], f[u][j-k] + f[son][k]);
                }
            }
        }
        // 将物品u加进去
        for (int i=m; i>=v[u]; i--){
            f[u][i] = f[u][i-v[u]] + w[u];
        }
        for (int i=0; i<v[u]; i++){
            f[u][i] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        int root = 0;
        for (int i=1; i<=n; i++){
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            int p = in.nextInt();
            if (p == -1){
                root = i;
            } else {
                add(p, i);
            }
        }
        dfs(root);
        System.out.println(f[root][m]);
    }
}
