package acwing.algorithmimprovement.dp.backpack.acwing1022;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/12 15:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int V1 = in.nextInt();
        int V2 = in.nextInt();
        int n = in.nextInt();
        int[][] f = new int[V1+1][V2+1];
        for (int i=0; i<n; i++){
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            for (int j=V1; j>=v1; j--){
                for (int k=V2-1; k>=v2; k--){
                    f[j][k] = Math.max(f[j][k], f[j-v1][k-v2] + 1);
                }
            }
        }
        System.out.print(f[V1][V2-1] + " ");
        int k = V2;
        while (k > 0 && f[V1][k-1] == f[V1][V2-1]){
            k--;
        }
        System.out.println(V2 - k);
    }
}
