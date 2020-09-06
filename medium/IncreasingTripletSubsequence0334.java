package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/25 15:23
 */
public class IncreasingTripletSubsequence0334 {
    public boolean increasingTriplet(int[] nums) {
        int k = 3;
        if (nums.length<k){
            return false;
        }
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums){
            if (num<=min){
                min = num;
            }
            else if (num<=mid){
                mid = num;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
