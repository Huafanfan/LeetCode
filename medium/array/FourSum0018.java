package medium.array;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/5 10:05
 *
 * 题目 #
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, 0 , target, path, res);
        return res;
    }

    public void dfs(int[] nums, int index, int sum,int target, Deque<Integer> path, List<List<Integer>> res){
        if (path.size()==4 && target==sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i<nums.length; i++){
            if (nums.length - i < 4 - path.size()){
                return;
            }
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i < nums.length - 1 && sum + nums[i] + (3 - path.size()) * nums[i + 1] > target) {
                return;
            }
            if (i < nums.length - 1 && sum + nums[i] + (3 - path.size()) * nums[nums.length - 1] < target) {
                continue;
            }
            path.addLast(nums[i]);
            dfs(nums, i + 1, sum + nums[i], target, path, res);
            path.removeLast();
        }
    }

    /**
     * 基本就是暴力解法
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        FourSum0018 fourSum0018 = new FourSum0018();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum0018.fourSum(nums, 0));
    }
}
