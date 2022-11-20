package acwing.algorithmimprovement.dp.backpack.acwing12;

import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/20 15:22
 */
public class Main {
    static int N = 1010;
    static int[][] f = new int[N][N];
    static int[] v = new int[N];
    static int[] w = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        for(int i = 1 ; i <= n ; i ++ ){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        for(int i = n ; i >= 1 ; i -- ){
            for(int j = 0 ; j <= m; j ++ ){
                f[i][j] = f[i+1][j];
                if (j >= v[i]){
                    f[i][j] = Math.max(f[i][j], f[i+1][j-v[i]] + w[i]);
                }
            }
        }

        // f[1][m] 是最大价值
        int j = m;
        for (int i=1; i<=n; i++){
            if (j >=v[i] && f[i][j] == f[i+1][j-v[i]] + w[i]){
                System.out.print(i + " ");
                j -= v[i];
            }
        }
    }
}
