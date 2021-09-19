package medium;

import byteDance.IsGraphBipartite;

import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/19 09:48
 */
public class TwoKeysKeyboard0650 {
    public int minSteps(int n) {
        if (n == 1){
            return 0;
        }
        int[] f = new int[n+1];
        f[1] = 0;
        f[2] = 2;
        for (int i=3; i<=n; i++){
            int prime = isPrime(i);
            if (prime == 1){
                f[i] = i;
            }else {
                f[i] = f[i / prime] + prime;
            }

        }
        return f[n];
    }

    public int isPrime(int n ){
        int k = (int) Math.sqrt(n);
        for (int i=2; i<=k; i++){
            if (n % i == 0){
                return i;
            }
        }
        return 1;
    }

    public int minSteps2(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard0650 twoKeysKeyboard0650 = new TwoKeysKeyboard0650();
        System.out.println(twoKeysKeyboard0650.minSteps(2));
    }
}
