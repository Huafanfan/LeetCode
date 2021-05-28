package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/28 14:16
 */
public class TotalHammingDistance0477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                res += hammingDistance(nums[i], nums[j]);
            }
        }
        return res;
    }
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int totalHammingDistance2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
