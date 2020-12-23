package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 16:32
 */
public class Lcof63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }
}
