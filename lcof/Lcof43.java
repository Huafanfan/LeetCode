package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 16:40
 */
public class Lcof43 {
    /**
     * 100.00%
     * 89.46%
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        int ret = 0;
        while (high !=0 || cur != 0){
            if (cur == 0){
                ret += high * digit;
            }
            else if (cur == 1){
                ret += high * digit + low + 1;
            }
            else {
                ret += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ret;
    }

    public int countDigitOne2(int n) {
        return f(n);
    }
    private int f(int n ) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high*pow;
        if (high == 1) {
            return f(pow-1) + last + 1 + f(last);
        } else {
            return pow + high*f(pow-1) + f(last);
        }
    }
}
