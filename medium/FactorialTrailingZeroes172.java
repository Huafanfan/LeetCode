package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/3/25 12:07
 */
public class FactorialTrailingZeroes172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
