package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/17 20:04
 */
public class TrappingRainWater0042 {
    public int trap(int[] height) {
        int length = height.length;
        if (length == 0){
            return 0;
        }
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i=1; i<length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int ans = 0;
        for (int i=0; i<length; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[bottom];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
