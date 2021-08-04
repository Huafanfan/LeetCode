package byteDance;

import java.util.Arrays;

public class Lcof0051 {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1, temp);
    }

    public int mergeSort(int[] nums, int left, int right, int[] temp){
        if (left >= right){
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int leftReversePairs = mergeSort(nums, left, mid, temp);
        int rightReversePairs = mergeSort(nums, mid+1, right, temp);
        if (nums[mid] <= nums[mid + 1]){
            return leftReversePairs + rightReversePairs;
        }
        int mergeReversePairs = mergeOfTwoSortedArray(nums, left, mid, right, temp);
        return leftReversePairs + mergeReversePairs + rightReversePairs;
    }

    public int mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp){
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int l = left;
        int r = mid + 1;
        int reversePairs = 0;
        for (int k = left; k <= right; k++){
            if (l == mid + 1){
                nums[k] = temp[r++];
            }
            else if (r == right + 1){
                nums[k] = temp[l++];
            }
            else if (temp[l] <= temp[r]){
                nums[k] = temp[l++];
            }
            else {
                reversePairs += mid + 1 - l;
                nums[k] = temp[r++];
            }
        }
        return reversePairs;
    }

    public static void main(String[] args) {
        Lcof0051 lcof0051 = new Lcof0051();
        int[] nums = new int[]{1,5,7,3,5,9};
        System.out.println(lcof0051.reversePairs(nums));
    }
}
