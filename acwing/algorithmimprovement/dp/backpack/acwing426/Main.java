package acwing.algorithmimprovement.dp.backpack.acwing426;

import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/20 14:21
 */
public class Main {
    static int N = 30010;
    static int[] f = new int[N];
    static int[] v = new int[N];
    static int[] w = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        for(int i = 1 ; i <= n ; i ++ ){
            int a = scan.nextInt();
            int b = scan.nextInt();
            v[i] = a;
            w[i] = a * b;
        }

        for(int i = 1 ; i <= n ; i ++ ){
            for(int j = m ; j >= v[i]; j -- ){
                f[j] = Math.max(f[j],f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
