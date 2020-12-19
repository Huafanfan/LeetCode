package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 17:25
 */
public class Lcof44 {
    /**
     * 100.00%
     * 79.42%
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1.
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2.
        long num = start + (n - 1) / digit;
        // 3.
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        Lcof44 lcof44 = new Lcof44();
        System.out.println(lcof44.findNthDigit(15));
    }
}
