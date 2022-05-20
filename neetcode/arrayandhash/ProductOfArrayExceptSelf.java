package neetcode.arrayandhash;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/20 10:48
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1, postfix = 1;
        for (int i=0; i<nums.length; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length-1; i>=0; i--){
            res[i] *= postfix;
            postfix *= nums[i];

        }
        return res;
    }
}
