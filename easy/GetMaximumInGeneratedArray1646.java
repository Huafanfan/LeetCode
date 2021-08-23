package easy;

public class GetMaximumInGeneratedArray1646 {
    public int getMaximumGenerated(int n) {
        if (n <= 1){
            return n;
        }
        int max = 1;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        int i = 1;
        while (2 * i <= n || 2 * i + 1 <= n){
            if (2 * i <= n){
                nums[2 * i] = nums[i];
                max = Math.max(max, nums[2 * i]);
            }
            if (2 * i + 1 <= n){
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[2 * i + 1]);
            }
            i++;
        }
        return max;
    }
}
