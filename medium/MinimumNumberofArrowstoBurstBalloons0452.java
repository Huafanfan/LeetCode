package medium;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/24 09:36
 */
public class MinimumNumberofArrowstoBurstBalloons0452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]){
                    return 1;
                }
                else if (o1[1] < o2[1]){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] ballon : points){
            if (ballon[0] > pos) {
                pos = ballon[1];
                ++ans;
            }
        }
        return ans;
    }
}
