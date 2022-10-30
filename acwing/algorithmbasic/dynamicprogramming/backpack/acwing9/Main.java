package acwing.algorithmbasic.dynamicprogramming.backpack.acwing9;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/5 17:11
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();

        int[] f = new int[m+1];

        for (int i=0; i<n; i++){
            int s = in.nextInt();
            int[] v = new int[s+1];
            int[] w = new int[s+1];
            for (int j=0; j<s; j++){
                v[j] = in.nextInt();
                w[j] = in.nextInt();
            }

            for (int j=m; j>=0; j--){
                for (int k=0; k<s; k++){
                    if (j-v[k] >= 0){
                        f[j] = Math.max(f[j], f[j-v[k]] + w[k]);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}
