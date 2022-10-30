package acwing.algorithmbasic.math.divisors.acwing870;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/10/1 17:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();

        Map<Integer, Integer> primes = new HashMap<>();

        while (n-- != 0){
            int x = in.nextInt();
            for (int i=2; i <= x / i; i++){
                while (x % i == 0){
                    x /= i;
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                }
            }
            if (x > 1){
                primes.put(x, primes.getOrDefault(x, 0) + 1);
            }
        }

        long res = 1;
        for (Integer value : primes.values()) {
            res = (res * (value + 1)) % 1000000007;
        }
        System.out.println(res);
    }
}
