package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 15:54
 */
public class Lcof14I {
    /**
     * 42.38%
     * 55.50%
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        for (int i=2; i<=n; i++){
            int curMax = 0;
            for (int j=1; j<i; j++){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    /**
     * 100.00%
     * 35.21%
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }

    /**
     * 大数
     * 100.00%
     * 73.71%
     * @param n
     * @return
     */
    public int cuttingRope3(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        int a = n / 3;
        for (int i=1; i<a; i++){
            rem = (rem * x) % p;
        }
        //for(int a = n / 3 - 1; a > 0; a /= 2) {
        //    if(a % 2 == 1) {
        //        rem = (rem * x) % p;
        //    }
        //    x = (x * x) % p;
        //}
        if(b == 0) {
            return (int)(rem * 3 % p);
        }
        if(b == 1) {
            return (int)(rem * 4 % p);
        }
        return (int)(rem * 6 % p);
    }

    public static void main(String[] args) {
        Lcof14I lcof14I = new Lcof14I();
        System.out.println(lcof14I.cuttingRope(10));
    }
}
