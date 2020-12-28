package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/28 09:48
 */
public class LargestRectangleinHistogram0084 {
    public int largestRectangleArea1(int[] heights) {
        int ret = 0;
        for (int i=0; i<heights.length; i++){
            int height = heights[i];
            int left = i;
            int right = i;
            while (left - 1 >= 0 && heights[left - 1] >= height){
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= height){
                right++;
            }
            ret = Math.max(ret, (right - left + 1) * height);
        }
        return ret;
    }

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return heights[0];
        }
        int area = 0;

        int[] newHeights = new int[len + 2];
        for (int i=0; i<len; i++){
            newHeights[i+1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i=1; i<len; i++){
            while (heights[stack.peekLast()] > heights[i]){
            //while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];

                //while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                //    stack.removeLast();
                //}

                int width = i - stack.peekLast() - 1;
                //if (stack.isEmpty()){
                //    width = i;
                //}else {
                //    width = i - stack.peekLast() - 1;
                //}
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        //while (!stack.isEmpty()){
        //    int height = heights[stack.removeLast()];
        //
        //    while (!stack.isEmpty() && heights[stack.peekLast()] == height){
        //        stack.removeLast();
        //    }
        //
        //    int width;
        //    if (stack.isEmpty()){
        //        width = len;
        //    }else {
        //        width = len - stack.peekLast() - 1;
        //    }
        //    area = Math.max(area, width * height);
        //}

        return area;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,6,2,3};
        LargestRectangleinHistogram0084 largestRectangleinHistogram0084 = new LargestRectangleinHistogram0084();
        System.out.println(largestRectangleinHistogram0084.largestRectangleArea3(heights));
    }
}
