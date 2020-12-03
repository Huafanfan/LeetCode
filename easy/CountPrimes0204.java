package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/3 09:13
 */
public class CountPrimes0204 {
    public int countPrimes(int n) {
        if (n<3){
            return 0;
        }
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i=2; i<n; i++){
            if (!isPrime[i]){
                count++;
                for (int j=i; j<n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes3(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        CountPrimes0204 countPrimes0204 = new CountPrimes0204();
        System.out.println(countPrimes0204.countPrimes(3));
    }
}
