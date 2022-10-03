package acwing.math.extendedeuclidean.acwing878;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/3 16:11
 */
public class Main {
    static int x;
    static int y;

    static int exgcd(int a, int b){
        if (b == 0){
            x = 1;
            y = 0;
            return a;
        }

        int d = exgcd(b, a % b);
        // 交换x，y
        int tmp = x;
        x = y;
        y = tmp -  a/b * x;
        return d;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();

        while (n-- >0){
            x = 0;
            y = 0;
            int a = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();
            int d = exgcd(a, m);
            if (b % d != 0){
                System.out.println("impossible");
            } else {
                System.out.println((long) x * (b / d) % m);
            }
        }
    }
}
