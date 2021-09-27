package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/27 16:02
 */
public class SumOfTwoIntegers0371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
