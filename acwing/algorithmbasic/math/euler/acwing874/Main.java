package acwing.algorithmbasic.math.euler.acwing874;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/2 16:03
 */
public class Main {
    static long getEulers(int n){
        int[] phi = new int[n+1];
        phi[1] = 1;
        int[] primes = new int[n+1];
        int cnt = 0;
        boolean[] st = new boolean[n+1];
        for (int i=2; i<=n; i++){
            if (!st[i]){
                primes[cnt++] = i;
                // 一个数是质数，那他的欧拉函数就是当前这个数-1
                phi[i] = i-1;
            }
            for (int j=0; primes[j] <= n/i; j++){
                st[primes[j] * i] = true;
                if (i % primes[j] == 0){
                    phi[primes[j] * i] = primes[j] * phi[i];
                    break;
                }
                phi[primes[j] * i] = (primes[j] - 1) * phi[i];
            }
        }
        long sum = 0;
        for (int num : phi){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        System.out.println(getEulers(n));
    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        int n = in.nextInt();
//        long sum = 0;
//        while (n != 0){
//            int a = n--;
//            int res = a;
//            for (int i=2; i<=a/i; i++){
//                if (a % i == 0){
//                    res = res / i * (i - 1);
//                    while (a % i == 0){
//                        a /= i;
//                    }
//                }
//            }
//            if (a > 1){
//                res = res / a * (a - 1);
//            }
//            sum += res;
//        }
//        System.out.println(sum);
//    }
}
