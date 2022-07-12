package neetcode.heap;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/11 09:11
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (point1, point2) -> (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    public int[][] kClosest2(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i=0; i<k; i++){
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i=k; i<n; i++){
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
