package acwing.math.combinations.acwing886;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/4 17:49
 */
public class Main {
    static int N = 100010;
    static int mod = 1000000007;
    static int[] fact = new int[N];
    static int[] infact = new int[N];

    static int qmi(int a, int k, int p){
        int res = 1;
        while (k != 0){
            if ((k&1) != 0){
                res = (int) ((long)res * a % p);
            }
            a = (int) ((long)a * a % p);
            k >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        fact[0] = infact[0] = 1;
        for (int i=1; i<N; i++){
            fact[i] = (int) ((long)fact[i-1] * i % mod);
            infact[i] = (int) ((long)infact[i-1] * qmi(i, mod-2, mod) % mod);
        }

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println((long)fact[a] * infact[b] % mod * infact[a - b] % mod);
        }
    }
}
