package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/14 10:06
 */
public class RichestCustomerWealth1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int money : account) {
                sum += money;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
