package acwing.base.prefixsum.acwing798;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 */
public class Main {
    static int N = 1010;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                a[i][j] = in.nextInt();
                insert(i, j, i, j, a[i][j]);
            }
        }
        while (q-- > 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int c = in.nextInt();
            insert(x1, y1, x2, y2, c);
        }
        for (int i=1; i<=n; i++){
            for (int j=1; j<m; j++){
                b[i][j] += b[i-1][j] + b[i][j-1] - b[i-1][j-1];
                System.out.print(b[i][j] + " ");
            }
            b[i][m] += b[i-1][m] + b[i][m-1] - b[i-1][m-1];
            System.out.println(b[i][m]);
        }
    }

    public static void insert(int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x2+1][y1] -= c;
        b[x1][y2+1] -=c;
        b[x2+1][y2+1] += c;
    }
}
