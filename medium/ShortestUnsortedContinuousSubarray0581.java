package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/11 20:55
 */
public class ShortestUnsortedContinuousSubarray0581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=1; i<len; i++){
            if (nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
            if (nums[len-i] < nums[len-i-1]){
                max = Math.max(max, nums[len-i-1]);
            }
        }
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE){
            return 0;
        }
        for (int i=0; i<len; i++){
            if (nums[i] > min){
                min = i;
                break;
            }
        }
        for (int i=len-1; i>=0; i--){
            if (nums[i] < max){
                max = i;
                break;
            }
        }
        return max - min + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray0581 shortestUnsortedContinuousSubarray0581 = new ShortestUnsortedContinuousSubarray0581();
        int[] arr = new int[]{2,6,4,8,10,9,15};
        System.out.println(shortestUnsortedContinuousSubarray0581.findUnsortedSubarray(arr));
    }
}
