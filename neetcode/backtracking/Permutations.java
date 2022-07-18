package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/18 09:32
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrace(0, nums);
        return res;
    }

    public void backTrace(int index, int[] nums){
        if (index == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }
            res.add(list);
            return;
        }
        backTrace(index+1, nums);
        for (int i=index+1; i<nums.length; i++){
            swap(nums, index, i);
            backTrace(index+1, nums);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = new int[]{1,2,3};
        System.out.println(p.permute(nums));
    }
}
