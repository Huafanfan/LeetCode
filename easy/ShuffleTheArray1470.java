package easy;

/**
 * @author yifan.zhangyf
 * @date 2022/8/29 8:48 PM
 */
public class ShuffleTheArray1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int i=0; i<n; i++){
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[n + i];
        }
        return ans;
    }
}
