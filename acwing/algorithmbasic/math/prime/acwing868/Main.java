package acwing.algorithmbasic.math.prime.acwing868;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/1 16:09
 */
public class Main {
    /**
     * n(log(n))
     */
    static int getPrimes1(int n){
        int[] primes = new int[n+1];
        int cnt = 0;
        boolean[] st = new boolean[n+1];
        for (int i=2; i <= n; i++){
            if (!st[i]){
                primes[cnt++] = i;
            }
            for (int j=i+i; j<=n; j+=i){
                st[j] = true;
            }
        }
        return cnt;
    }

    /**
     * n(log(log(n)))
     */
    static int getPrimes2(int n){
        int[] primes = new int[n+1];
        int cnt = 0;
        boolean[] st = new boolean[n+1];
        for (int i=2; i <= n; i++){
            if (!st[i]){
                primes[cnt++] = i;
                for (int j=i+i; j<=n; j+=i){
                    st[j] = true;
                }
            }
        }
        return cnt;
    }

    /**
     * n
     */
    static int getPrimes3(int n){
        int[] primes = new int[n+1];
        int cnt = 0;
        boolean[] st = new boolean[n+1];
        for (int i=2; i <= n; i++){
            if (!st[i]){
                primes[cnt++] = i;
            }
            for (int j=0; primes[j] <= n / i; j++){
                st[primes[j] * i] = true;
                if (i % primes[j] == 0){
                    // primes[j] 一定是i的最小质因子，primes[j] 一定是primes[j] * i的最小质因子
                    break;
                }
                // primes[j] 一定小于i的所有质因子，primes[j] 也一定是primes[j] * i的最小质因子
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int cnt = getPrimes3(n);
        System.out.println(cnt);
    }
}
