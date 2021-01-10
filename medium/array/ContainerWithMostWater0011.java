package medium.array;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/26 13:46
 *
 * 题目 #
 * Given n non-negative integers a1, a2, …, an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater0011 {
    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max=0;
        for (int i=0,j=height.length-1;i<j;){
            max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]<=height[j]){
                //int temp=height[i];
                //while (temp>height[i+1]){
                //    i++;
                //}
                i++;
            }
            else{
                //int temp=height[j];
                //while (temp>height[j-1]){
                //    j--;
                //}
                j--;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
