package acwing.math.prime.acwing867;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/1 15:57
 */
public class Main {
    static void divide(int n){
        for (int i=2; i <= n / i; i++){
            if (n % i == 0){
                int count = 0;
                while (n % i == 0){
                    n /= i;
                    count++;
                }
                System.out.println(i + " " + count);
            }
        }
        if (n > 1){
            System.out.println(n + " " + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- != 0){
            divide(in.nextInt());
            System.out.println();
        }
    }
}
