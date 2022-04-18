package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/18 10:02
 */
public class LargestPalindromeProduct0479 {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        // 枚举回文数的左半部分
        for (int left = upper; ans == 0; --left) {
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                // 翻转左半部分到其自身末尾，构造回文数 p
                p = p * 10 + x % 10;
            }
            for (long x = upper; x * x >= p; --x) {
                // x 是 p 的因子
                if (p % x == 0) {
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
