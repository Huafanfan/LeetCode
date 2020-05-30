package com.huafanfan.medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/30 14:49
 */
public class SearchinRotatedSortedArray0033 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length==0){
            return -1;
        }
        if(length==1){
            return nums[0]==target?0:-1;
        }
        int left=0;
        int right=length-1;
        while (left<=right){
            int middle = (left+right)>>2;
            if (nums[middle]==target){
                return middle;
            }
            if(nums[0]<=nums[middle]){
                if (nums[0]<=target&&target<nums[middle]){
                    right = middle-1;
                }
                else{
                    left=middle+1;
                }
            }
            else {
                if (nums[middle]<target&&target<=nums[length-1]){
                    left=middle+1;
                }
                else {
                    right=middle-1;
                }
            }
        }
        return -1;
    }
}
