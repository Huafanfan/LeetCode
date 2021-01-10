package easy.array;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/10 11:47
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 */
public class MissingNumber0268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //判断是否有1
        boolean isHave1 = false;
        for (int num : nums){
            if (num == 1){
                isHave1 = true;
                break;
            }
        }
        if (!isHave1){
            return 1;
        }

        for (int i=0; i<n; i++){
            if (nums[i]<1){
                nums[i] = 1;
            }
        }

        for (int i=0; i<n; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for (int i=0; i<n; i++){
            if (nums[i]>0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
