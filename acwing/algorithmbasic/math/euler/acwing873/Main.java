package acwing.algorithmbasic.math.euler.acwing873;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/2 15:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- !=0){
            int a = in.nextInt();
            int res = a;
            for (int i=2; i<=a/i; i++){
                if (a % i == 0){
                    res = res / i * (i - 1);
                    while (a % i == 0){
                        a /= i;
                    }
                }
            }
            if (a > 1){
                res = res / a * (a - 1);
            }
            System.out.println(res);
        }
    }
}
