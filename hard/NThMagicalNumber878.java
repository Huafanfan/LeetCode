package hard;

/**
 * @author yifan.zhangyf
 * @date 2022/11/22 10:32
 */
public class NThMagicalNumber878 {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        // 二分
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        // 最大公倍数
        int c = lcm(a, b);
        // f(x) 表示为小于等于 xx 的「神奇数字」个数
        // f(x)=⌊x/a⌋ + ⌊x/b⌋ - ⌊x/lcm(a,b)⌋

        while (l < r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) (l % MOD);
    }
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
