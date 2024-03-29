package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/11 09:05
 */
public class NonNegativeIntegersWithoutConsecutiveOnes0600 {
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                n -= val;
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NonNegativeIntegersWithoutConsecutiveOnes0600 nonNegativeIntegersWithoutConsecutiveOnes0600 = new NonNegativeIntegersWithoutConsecutiveOnes0600();
        System.out.println(nonNegativeIntegersWithoutConsecutiveOnes0600.findIntegers(6));
    }
}
