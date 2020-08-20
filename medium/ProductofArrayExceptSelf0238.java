package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/20 11:37
 */
public class ProductofArrayExceptSelf0238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        int prefix = 1;
        int suffix = 1;
        for (int i=0; i<n; i++){
            result[i]*=prefix;
            result[n-i-1]*=suffix;
            prefix*=nums[i];
            suffix*=nums[n-i-1];
        }
        return result;
    }
    public int[] productExceptSelf2(int[] nums) {
        int n=nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i=1; i<n; i++){
            result[i] = nums[i-1] * result[i-1];
        }
        int R=1;
        for (int i=n-1; i>=0; i--){
            result[i] = result[i] * R;
            R *= nums[i];
        }
        return result;
    }
}
