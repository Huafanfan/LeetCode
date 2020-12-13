package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/13 09:22
 */
public class ContainsDuplicate0217 {
    /**
     * 要求所有数为大于0
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i=0; i<nums.length;){
            if (nums[i] != i + 1){
                if (nums[nums[i]-1] == nums[i]){
                    return true;
                }
                else {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }else {
                i++;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
