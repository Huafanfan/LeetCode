package microsoft;

import java.util.Arrays;

public class ProductOfArrayExceptSelf0238 {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1, suffix = 1;
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        for (int i=0; i<len; i++){
            ans[i] *= prefix;
            ans[len - i -1] *= suffix;
            prefix *= nums[i];
            suffix *= nums[len - i - 1];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i=1; i<len; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i=len - 1; i>=0; i--){
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf0238 productOfArrayExceptSelf0238 = new ProductOfArrayExceptSelf0238();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf0238.productExceptSelf(nums)));
    }
}
