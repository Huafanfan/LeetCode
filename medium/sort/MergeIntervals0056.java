package medium.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/4 10:12
 */
public class MergeIntervals0056 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int index = 0;
        if (intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        result.add(index,intervals[0]);
        for (int i=1; i< intervals.length; i++){
            if (intervals[i][0]>result.get(index)[1]){
                result.add(++index,intervals[i]);
            }
            else{
                result.get(index)[1] = Math.max(intervals[i][1],result.get(index)[1]);
            }
        }
        return result.toArray(new int[0][]);
    }



}
