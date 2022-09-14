package acwing.searchgraphtheory.dfs.acwing843;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/14 9:53 PM
 */
public class Main {
    static int N = 20;
    static int n;
    static char[][] g;
    static boolean[] row = new boolean[N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        g =new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                g[i][j] = '.';
            }
        }
        dfs(0, 0, 0);
    }
    static void dfs(int u){
        if (u == n){
            for (int i=0; i<n; i++){
                System.out.println(g[i]);
            }
            System.out.println();
            return;
        }
        for (int i=0; i<n; i++){
            // u 代表行，杜绝了同一行的问题，所以只用判断列
            // u+i 就是坐标x+y,同一对角线上的x+y相同
            // n+i-u 就是坐标x-y+n，同一反对角线上的x-y+n相同
            if (!col[i] && !dg[u+i] && !udg[n-u+i]){
                g[u][i] = 'Q';
                col[i] = true;
                dg[u+i] = true;
                udg[n-u+i] = true;
                dfs(u+1);
                g[u][i] = '.';
                col[i] = false;
                dg[u+i] = false;
                udg[n-u+i] = false;
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param s 皇后数
     */
    static void dfs(int x, int y, int s){
        if (y == n){
            x++;
            y = 0;
        }
        if (x == n){
            if (s == n){
                for (int i=0; i<n; i++){
                    System.out.println(g[i]);
                }
                System.out.println();
            }
            // 皇后数可能小于n，此时只是返回
            return;
        }
        dfs(x, y+1, s);

        if (!row[x] && !col[y] && !dg[x+y] && !udg[x-y+n]){
            g[x][y] = 'Q';
            row[x] = true;
            col[y] = true;
            dg[x+y] = true;
            udg[x-y+n] = true;
            dfs(x, y+1, s+1);
            g[x][y] = '.';
            row[x] = false;
            col[y] = false;
            dg[x+y] = false;
            udg[x-y+n] = false;
        }
    }
}
