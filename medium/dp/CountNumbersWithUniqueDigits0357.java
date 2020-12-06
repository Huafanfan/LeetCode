package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/6 09:36
 */
public class CountNumbersWithUniqueDigits0357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0) {
            return 1;
        }
        int res = 10, uniqueDigits = 9, availableDigits = 9;
        while (n>1 && availableDigits>0) {
            uniqueDigits *= availableDigits;
            res += uniqueDigits;
            availableDigits--;
            n--;
        }
        return res;
    }

}
