package acwing.math.divisors.acwing872;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/1 17:44
 */
public class Main {
    static int gcd(int a, int b){
        return b != 0 ? gcd(b, a % b) : a;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();

        while (n-- >0){
            System.out.println(gcd(in.nextInt(), in.nextInt()));
        }
    }
}
