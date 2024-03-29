package medium;

import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/9 10:41
 */
public class RandomPointInNonOverlappingRectangles0497 {
    int[][] rs;
    int[] sum;
    int n;
    Random random = new Random();

    public RandomPointInNonOverlappingRectangles0497(int[][] rects) {
        rs = rects;
        n = rs.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
        }
    }

    public int[] pick() {
        int val = random.nextInt(sum[n]) + 1;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int[] cur = rs[r - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }
}
