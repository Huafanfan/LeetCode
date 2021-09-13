package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/13 09:51
 */
public class NumberOfBoomerangs0447 {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 2){
            return 0;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i=0; i<points.length; i++){
            for (int j=0; j<points.length; j++){
                if (i == j){
                    continue;
                }
                Map<Integer, Integer> cur = map.getOrDefault(i, new HashMap<>());
                int dis = distance(points[i], points[j]);
                int count = cur.getOrDefault(dis, 0 );
                cur.put(dis, count+1);
                map.put(i, cur);
            }
        }
        int res = 0;
        for (int i=0; i<points.length; i++){
            Map<Integer, Integer> cur = map.getOrDefault(i, new HashMap<>());
            for (Map.Entry<Integer, Integer> entry : cur.entrySet()){
                if (entry.getValue() > 1){
                    res += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return res;
    }

    public int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public int distance(int[] point1, int[] point2){
        return (int)Math.pow(point1[0] - point2[0], 2) + (int)Math.pow(point1[1] - point2[1], 2);
    }

    public static void main(String[] args) {
        NumberOfBoomerangs0447 numberOfBoomerangs0447 = new NumberOfBoomerangs0447();
        int[][] points = new int[][]{{1,1}, {2,2}, {3,3}};
        System.out.println(numberOfBoomerangs0447.numberOfBoomerangs(points));
    }
}
