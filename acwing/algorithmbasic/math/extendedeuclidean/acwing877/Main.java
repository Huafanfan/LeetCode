package acwing.algorithmbasic.math.extendedeuclidean.acwing877;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/3 15:44
 */
public class Main {
    static int x = 0;
    static int y = 0;
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
            exgcd(in.nextInt(), in.nextInt());
            System.out.println(x + " " + y);
        }
    }
}
