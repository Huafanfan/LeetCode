package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/4 09:30
 */
public class InsertInterval0057 {
    static class Solution {
        public static int[][] insert(int[][] intervals, int[] newInterval) {
            List<List<Integer>> tempRes = new ArrayList<>();
            int start = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;
            for (int i=0; i<intervals.length; i++){
                if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]){
                    start = i;
                }
                if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]){
                    end = i;
                }
                if (i > 0){
                    if (intervals[i][0] > newInterval[0] && intervals[i - 1][1] < newInterval[0] && start == Integer.MAX_VALUE){
                        start = i;
                    }
                }
                if (i > 0){
                    if (intervals[i][1] > newInterval[1] && intervals[i - 1][1] < newInterval[1] && end == Integer.MIN_VALUE){
                        end = i - 1;
                    }
                }
                List<Integer> tempList = new ArrayList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[i][1]);
                tempRes.add(tempList);
            }
            List<Integer> newList = new ArrayList<>();
            if (start == Integer.MAX_VALUE){
                newList.add(newInterval[0]);
                if (end == Integer.MIN_VALUE){
                    newList.add(newInterval[1]);
                    if (intervals.length == 0){
                        tempRes.add(newList);
                    }else if (newInterval[0] > intervals[intervals.length-1][1]){
                        tempRes.add(newList);
                    } else if (newInterval[1] < intervals[0][0]) {
                        tempRes.add(0, newList);
                    }
                    else {
                        tempRes.clear();
                        tempRes.add(newList);
                    }
                } else {
                    newList.add(Math.max(intervals[end][1], newInterval[1]));
                    tempRes.subList(0, end + 1).clear();
                    tempRes.add(0, newList);
                }
            }
            else {
                newList.add(Math.min(intervals[start][0], newInterval[0]));
                if (end == Integer.MIN_VALUE) {
                    newList.add(newInterval[1]);
                    tempRes.subList(start, tempRes.size()).clear();
                } else {
                    newList.add(Math.max(intervals[end][1], newInterval[1]));
                    if (start == end){
                        tempRes.remove(start);
                    }
                    else {
                        tempRes.subList(start, end + 1).clear();
                    }
                }
                tempRes.add(start, newList);

            }
            int[][] res = new int[tempRes.size()][2];
            for (int i=0; i<tempRes.size(); i++){
                res[i][0] = tempRes.get(i).get(0);
                res[i][1] = tempRes.get(i).get(1);
            }
            return res;
        }

        public static int[][] insert2(int[][] intervals, int[] newInterval) {
            int left = newInterval[0];
            int right = newInterval[1];
            boolean placed = false;
            List<int[]> ansList = new ArrayList<int[]>();
            for (int[] interval : intervals) {
                if (interval[0] > right) {
                    // 在插入区间的右侧且无交集
                    if (!placed) {
                        ansList.add(new int[]{left, right});
                        placed = true;
                    }
                    ansList.add(interval);
                } else if (interval[1] < left) {
                    // 在插入区间的左侧且无交集
                    ansList.add(interval);
                } else {
                    // 与插入区间有交集，计算它们的并集
                    left = Math.min(left, interval[0]);
                    right = Math.max(right, interval[1]);
                }
            }
            if (!placed) {
                ansList.add(new int[]{left, right});
            }
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); ++i) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }

        public static void main(String[] args) {
            int[][] intervals1 = new int[][]{{1, 3},{6, 9}};
            int[] newInterval1 = new int[]{2, 5};

            int[][] intervals2 = new int[][]{{1, 2},{3, 5},{6, 7},{8, 10},{12, 16}};
            int[] newInterval2 = new int[]{5, 8};

            int[][] intervals3 = new int[][]{{1, 3}};
            int[] newInterval3 = new int[]{2, 5};

            int[][] intervals4 = new int[][]{};
            int[] newInterval4 = new int[]{2, 5};

            int[][] intervals5 = new int[][]{{0, 5}, {9, 12}};
            int[] newInterval5 = new int[]{7, 16};
            Solution.insert(intervals2, newInterval2);
        }
    }
}
