package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/9 12:00
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i=0; i<heights.length; i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] last = stack.poll();
                int index = last[0];
                int height = last[1];
                ans = Math.max(ans, (i - index) * height);
                start = last[0];
            }
            stack.push(new int[]{start, heights[i]});
            //if (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
            //    int[] last = null;
            //    while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
            //        last = stack.poll();
            //        ans = Math.max(ans, (i - last[0]) * last[1]);
            //    }
            //    stack.push(new int[]{last[0], heights[i]});
            //} else {
            //    stack.push(new int[]{i, heights[i]});
            //}
        }
        while (!stack.isEmpty()){
            int[] last = stack.poll();
            int index = last[0];
            int height = last[1];
            ans = Math.max(ans, (heights.length - index) * height);
        }
        return ans;
    }
}
