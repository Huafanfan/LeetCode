package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/6/1 10:28
 */
public class CanYouEatYourFavoriteCandyOnYourFavoriteDay1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int length = candiesCount.length;
        long[] sum = new long[length];
        sum[0] = candiesCount[0];
        for (int i=1; i<length; i++){
            sum[i] = sum[i-1] + candiesCount[i];
        }
        int n = queries.length;
        boolean[] res = new boolean[n];
        for (int i=0; i<n; i++){
            int type = queries[i][0];
            int day =  queries[i][1];
            int cap = queries[i][2];
            long x1 = day + 1;
            long y1 = (long) (day + 1) * cap;

            long x2 = type == 0 ? 1 : sum[type-1] + 1;
            long y2 = sum[type];

            res[i] = !(x2 > y1 || x1 > y2);
        }
        return res;
    }
}
