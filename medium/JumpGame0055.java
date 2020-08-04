package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/4 9:43
 */
public class JumpGame0055 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightmost = 0;
        for (int i=0; i<length; i++){
            if (i <= rightmost){
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost>=length-1){
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }
    public boolean canJump1(int[] nums) {
        int k = 0;
        for (int i=0; i< nums.length; i++){
            if (i>k){
                return false;
            }
            k = Math.max(k,i+nums[i]);
        }
        return true;
    }
}
