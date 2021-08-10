package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/8/10 10:17
 */
public class ArithmeticSlices0413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length-2; i++){
            int j = i+1;
            int diff = nums[j] - nums[i];
            for (int k=j+1; k<nums.length; k++){
                if (nums[k] - nums[k-1] == diff){
                    res++;
                }
                else {
                    break;
                }
            }
        }
        return res;
    }
}
