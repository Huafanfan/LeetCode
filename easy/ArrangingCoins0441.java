package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/10 10:13
 */
public class ArrangingCoins0441 {
    public int arrangeCoins(int n) {
        int length = 0;
        for (int i=1; i<=n; i++){
            length++;
            n-=i;
        }
        return length;
    }

    public int arrangeCoins2(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int arrangeCoins3(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
}
