package acwing.dynamicprogramming.memoizedsearch.acwing901;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/22 21:40
 */
public class Main {
    static int N = 310;
    static int n, m;
    static int[][] h = new int[N][N];
    static int[][] f = new int[N][N];

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int dp(int x, int y){
        if (f[x][y] != -1){
            return f[x][y];
        }
        f[x][y] = 1;
        for (int i=0; i<4; i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >=1 && a<=n && b >=1 && b <= m && h[a][b] < h[x][y]){
                f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
            }
        }
        return f[x][y];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                h[i][j] = in.nextInt();
            }
        }
        for (int i=0; i<N; i++){
            Arrays.fill(f[i], -1);
        }
        int res = 0;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                res = Math.max(res, dp(i, j));
            }
        }
        System.out.println(res);
    }
}
