package medium;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum0930 {
    /**
     * 超时
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i=0; i<nums.length; i++){
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }
        int res = 0;
        for (int length = 1; length <= nums.length; length++){
            for (int i=0; i<=nums.length - length; i++){
                if (prefixSum[i + length] - prefixSum[i] == goal){
                    res++;
                }
            }
        }
        return res;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum0930 binarySubarraysWithSum0930 = new BinarySubarraysWithSum0930();
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(binarySubarraysWithSum0930.numSubarraysWithSum2(nums, 2));
    }
}
