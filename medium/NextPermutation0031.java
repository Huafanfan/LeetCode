package com.huafanfan.medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/30 11:22
 */
public class NextPermutation0031 {
    public void nextPermutation(int[] nums) {
        //nums是0～n-1的一个全排列:n=n1n2......nn=n1n2......ni-1nini+1......nk-1nknk+1......nn
        if (nums.length<=1){
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;
        //从排列的右端开始，找出第一个比右边数字小的数字的序号i
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i >= 0) {
            //在ni的右边的数字中，找出所有比ni大的数中最小的数字nk
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
