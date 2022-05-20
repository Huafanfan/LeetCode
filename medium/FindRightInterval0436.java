package medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/20 10:13
 */
public class FindRightInterval0436 {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        int[] starts = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<intervals.length; i++){
            starts[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }
        Arrays.sort(starts);
        for (int i=0; i<intervals.length; i++){
            int end = intervals[i][1];
            int l=0, r=intervals.length-1;
            while (l < r){
                int mid = (l+r) >> 1;
                if (starts[mid] >= end){
                    r = mid;
                }
                else {
                    l = mid + 1;
                }
            }
            if (starts[l] >= end){
                res[i] = map.get(starts[l]);
            } else {
                res[i] = -1;
            }

        }
        return res;
    }
}
