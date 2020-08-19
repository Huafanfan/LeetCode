package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/19 16:07
 */
public class MajorityElementii0229 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        MajorityElementii0229 majorityElementii0229 = new MajorityElementii0229();
        System.out.println(majorityElementii0229.majorityElement(nums));
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums==null||nums.length==0){
            return result;
        }
        int candidate1 = nums[0];
        int count1 = 0;
        int candidate2 = nums[0];
        int count2 = 0;
        for (int num : nums){
            // 投票
            if (candidate1 == num) {
                count1++;
                continue;
            }
            if (candidate2 == num) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                candidate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}
