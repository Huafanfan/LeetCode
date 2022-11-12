package acwing.algorithmimprovement.dp.backpack.acwing1023;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/12 16:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
//        int[][] f = new int[5][m+1];
//        int[] v = new int[]{0, 10, 20, 50, 100};
//        f[0][0] = 1;
//        for (int i=1; i<=4; i++){
//            for (int j=0; j<=m; j++){
//                f[i][j] = f[i-1][j];
//                if (j >= v[i]){
//                    f[i][j] += f[i][j - v[i]];
//                }
//            }
//        }
//        System.out.println(f[4][m]);
        int[] f = new int[m+1];
        int[] v = new int[]{0, 10, 20, 50, 100};
        f[0] = 1;
        for (int i=1; i<=4; i++){
            for (int j=0; j<=m; j++){
                if (j >= v[i]){
                    f[j] += f[j - v[i]];
                }
            }
        }
        System.out.println(f[m]);
    }
}
