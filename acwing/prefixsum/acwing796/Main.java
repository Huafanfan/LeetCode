package acwing.prefixsum.acwing796;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/12 17:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[][] matrix = new int[n+1][m+1];

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1] + in.nextInt();
            }
        }
        while (q-- > 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            System.out.println(matrix[x2][y2] - matrix[x2][y1-1] - matrix[x1-1][y2] + matrix[x1-1][y1-1]);
        }
    }
}
