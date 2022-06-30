package easy;/**
 * @author  Alex
 * @date  2022/6/30 10:14
 * @version 1.0
 */public class PrimeArrangements1175 {
    static final int MOD = 1000000007;

    /**
     * 根据题意，可将问题转换为求 n 以内的质数个数，记为 a，同时可得非质数个数为 b = n - a。
     * 质数的放置方案数为 a!，而非质数的放置方案数为 b!，根据「乘法原理」总的放置方案数为 a!×b!。
     *
     * @param n
     * @return
     */
    public int numPrimeArrangements(int n) {
        int numPrimes = 0;
        for (int i=1; i<=n; i++){
            if (isPrime(i)){
                numPrimes++;
            }
        }
        return (int) (factorial(numPrimes) * factorial(n - numPrimes) % MOD);
    }

    public boolean isPrime(int n){
        if (n == 1){
            return false;
        }
        for (int i=2; i*i <=n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public long factorial(int n){
        long res = 1;
        for (int i=1; i<=n; i++){
            res *= i;
            res %= MOD;
        }
        return res;
    }
}
