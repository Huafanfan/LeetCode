package acwing.algorithmimprovement.dp.backpack.acwing11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/20 15:22
 */
public class Main {
    static int N = 1010;
    static int[] f = new int[N];
    static int[] g = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        Arrays.fill(f, -0x3f);
        f[0] = 0;
        g[0] = 1;


        for(int i = 0 ; i < n ; i ++ ){
            int v = scan.nextInt();
            int w = scan.nextInt();
            for(int j = m ; j >= v; j -- ){
                int max = Math.max(f[j], f[j-v]+w);
                int cnt = 0;
                if (max == f[j]){
                    cnt += g[j];
                }
                if (max == f[j-v]+w){
                    cnt += g[j-v];
                }
                g[j] = cnt % 1000000007;
                f[j] = max;
            }
        }
        int res = 0;
        for (int i=0; i<=m; i++){
            res = Math.max(res, f[i]);
        }
        int cnt = 0;
        for (int i=0; i<=m; i++){
            if (f[i] == res){
                cnt = (cnt + g[i]) % 1000000007;
            }
        }
        System.out.println(cnt);
    }
}
