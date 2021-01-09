package medium.array;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/9 09:35
 */
public class ThreeSumClosest0016 {
    public int threeSumClosest(int[] nums, int target) {
        int closeSum = 10000000;
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 1; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closeSum - target)) {
                    closeSum = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return closeSum;
    }
}
