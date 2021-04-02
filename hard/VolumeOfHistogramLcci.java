package hard;

import java.util.Deque;
import java.util.LinkedList;

public class VolumeOfHistogramLcci {
    public int trap(int[] height) {
        int len = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i=0; i<len; i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                res += (i - left - 1) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        VolumeOfHistogramLcci volumeOfHistogramLcci = new VolumeOfHistogramLcci();
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(volumeOfHistogramLcci.trap(nums));
    }
}
