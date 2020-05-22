package com.huafanfan;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/21 10:56
 */
public class MoveZeroes0283 {
    public void moveZeroes(int[] nums) {
        if (nums.length==0||nums.length==1){
            return;
        }
        for (int l=0,f=0; f<nums.length; f++){
            if (nums[f]!=0){
                nums[l] = nums[f];
                if(f != l){
                    nums[f] = 0;
                }
                l++;
            }
        }
    }
}
