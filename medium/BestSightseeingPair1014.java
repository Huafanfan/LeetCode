package medium;

import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/10 11:07
 */
public class BestSightseeingPair1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int result = 0;
        //int mx = A[0] + 0;
        int mx = A[0];
        for (int j=1; j<A.length; j++){
            result = Math.max(result, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return result;
    }
}
