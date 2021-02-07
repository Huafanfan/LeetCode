package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/7 14:30
 */
public class MaximumPointsYouCanObtainFromCards1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windows = n - k;
        int sum = 0;
        for (int i=0; i<windows; i++){
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i=windows; i<n; i++){
            sum += cardPoints[i] - cardPoints[i-windows];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
