package acwing.algorithmimprovement.dp.backpack.acwing8;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/13 17:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int V1 = in.nextInt();
        int V2 = in.nextInt();
        int[][] f = new int[V1+1][V2+1];
        for (int i=0; i<n; i++){
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int w = in.nextInt();
            for (int j=V1; j>=v1; j--){
                for (int k=V2; k>=v2; k--){
                    f[j][k] = Math.max(f[j][k], f[j-v1][k-v2] + w);
                }
            }
        }
        System.out.println(f[V1][V2]);
    }
}
