package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/13 16:08
 */
public class BitwiseAndOfNumbersRange0201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n){
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // turn off rightmost 1-bit
            n = n & (n - 1);
        }
        return m & n;
    }
}
