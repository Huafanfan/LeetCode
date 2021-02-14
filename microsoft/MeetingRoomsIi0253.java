package microsoft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 16:30
 */
public class MeetingRoomsIi0253 {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i=1; i<len; i++){
            if (intervals[i][0] >= pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
    public int minMeetingRooms2(int[][] intervals) {
        int len = intervals.length;
        Integer[] start = new Integer[len];
        Integer[] end = new Integer[len];
        int index = 0;
        for (int[] interval : intervals) {
            start[index] = interval[0];
            end[index] = interval[1];
            index++;
        }
        Arrays.sort(start, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(end, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int sPtr = 0;
        int ePtr = 0;
        int res = 0;
        for (; sPtr<len; sPtr++){
            if (start[sPtr] < end[ePtr]){
                res++;
            }
            else {
                ePtr++;
            }
        }
        return res;
    }
}
