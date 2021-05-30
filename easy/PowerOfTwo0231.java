package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/30 10:06
 */
public class PowerOfTwo0231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
