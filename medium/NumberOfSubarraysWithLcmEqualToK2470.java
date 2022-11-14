package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/11/14 22:13
 */
public class NumberOfSubarraysWithLcmEqualToK2470 {
    public int gcd(int a, int b){
        return b != 0 ? gcd(b , a % b) : a;
    }
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for (int i=0; i<nums.length; i++){
            int t = nums[i];
            for (int j=i; j<nums.length; j++){
                t = t * nums[j] / gcd(t, nums[j]);
                if (t == k){
                    res++;
                } else if (t > k){
                    break;
                }
            }
        }
        return res;
    }
}
