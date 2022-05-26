package neetcode.twopointers;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/25 17:51
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int maxLeft = 0, maxRight = 0;
        for (int i=1; i<height.length; i++){
            maxLeft = Math.max(maxLeft, height[i-1]);
            left[i] = maxLeft;
        }
        for (int i=height.length-2; i>=0; i--){
            maxRight = Math.max(maxRight, height[i+1]);
            right[i] = maxRight;
        }
        int rain = 0;
        for (int i=0; i<height.length; i++){
            if (left[i] > height[i] && right[i] > height[i]){
                rain += Math.min(left[i], right[i]) - height[i];
            }
        }
        return rain;
    }

    public int trap2(int[] height) {
        if (height.length <= 2){
            return 0;
        }
        int rain =0, l = 0, r = height.length-1;
        int maxLeft = height[l], maxRight = height[r];
        while (l < r){
            if (maxLeft <= maxRight){
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                rain += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                rain += maxRight - height[r];
            }
        }
        return rain;
    }
}
