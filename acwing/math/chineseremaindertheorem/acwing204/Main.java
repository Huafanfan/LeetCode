package acwing.math.chineseremaindertheorem.acwing204;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/3 16:26
 */
public class Main {
    static long x;
    static long y;

    static long exgcd(long a, long b){
        if (b == 0){
            x = 1;
            y = 0;
            return a;
        }

        long d = exgcd(b, a % b);
        // 交换x，y
        long tmp = x;
        x = y;
        y = tmp -  a/b * x;
        return d;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();

        boolean hasAnswer = true;
        long a1 = in.nextLong();
        long m1 = in.nextLong();

        for (int i=0; i<n-1; i++){
            long a2 = in.nextLong();
            long m2 = in.nextLong();
            x = 0;
            y = 0;
            long d = exgcd(a1, a2);
            if ((m2 - m1) % d != 0){
                hasAnswer = false;
                break;
            }

            //扩大(m2 - m1) / d 倍
            x *= (m2 - m1) / d;


            long t = a2 / d;
            // ?
            x = (x % t + t) % t;


            m1 = a1 * x + m1;
            // a1和a2的最小公倍数
            a1 = Math.abs(a1 / d * a2);
        }

        if (hasAnswer){
            System.out.println((m1 % a1 + a1) % a1);
        } else {
            System.out.println("-1");
        }
    }
}
