package byteDance;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left != right){
            int curWater = (right - left) * Math.min(height[left], height[right]);
            if (curWater > maxWater){
                maxWater = curWater;
            }
            if (height[left] <= height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater.maxArea(nums));
    }
}
