package com.huafanfan.medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/30 11:22
 */
public class NextPermutation0031 {
    public void nextPermutation(int[] nums) {
        if (nums.length<=1){
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, j);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
