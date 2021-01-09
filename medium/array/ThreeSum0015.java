package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/26 14:06
 */
public class ThreeSum0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if(len < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]>0){
                return lists;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=len-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left<right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return lists;
    }
}
