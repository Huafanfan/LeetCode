package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 17:18
 */
public class MergeIntervals0056 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<Integer> interval = new ArrayList<>();
        interval.add(intervals[0][0]);
        interval.add(intervals[0][1]);
        for (int i=1; i<len; i++){
            if (intervals[i][0] <= interval.get(1)) {
                interval.set(1, Math.max(interval.get(1), intervals[i][1]));
            }
            else {
                resList.add(new ArrayList<>(interval));
                interval.set(0, intervals[i][0]);
                interval.set(1, intervals[i][1]);
            }

        }
        resList.add(new ArrayList<>(interval));
        int[][] res = new int[resList.size()][2];
        for (int i=0; i<resList.size(); i++){
            res[i][0] = resList.get(i).get(0);
            res[i][1] = resList.get(i).get(1);
        }
        return res;
    }
}
