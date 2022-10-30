package acwing.algorithmbasic.math.prime.acwing866;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/1 15:45
 */
public class Main {
    static boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        for (int i=2; i <= n / i; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- != 0){
            if (isPrime(in.nextInt())){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
