package acwing.searchgraphtheory.floyd.acwing854;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/25 12:24 PM
 */
public class Main {
    static int N = 210;
    static int INF = 1000000000;
    static int n;
    static int m;
    static int Q;
    static int[][] d = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Q = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                d[i][j] = i == j ? 0 : INF;
            }
        }
        while (m-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }

        floyd();

        while (Q-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            if (d[a][b] > INF / 2){
                System.out.println("impossible");
            } else {
                System.out.println(d[a][b]);
            }
        }
    }

    static void floyd(){
        for (int k=1; k<=n; k++){
            for (int i=1; i<=n; i++){
                for (int j=1; j<=n; j++){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
