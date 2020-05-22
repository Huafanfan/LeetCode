package com.huafanfan;

/**
 * @author alex
 */
public class RemoveDuplicates0026 {

	public static void main(String[] args){
		int[] a = new int[] {0,0};
		int b = removeDuplicates(a);
		System.out.println(b);
		for(int temp:a){
			System.out.print(temp+" ");
		}
	}
	
    public static int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int length = nums.length;
    	int cur_index = 0;
    	for(int i=1;i<length;i++) {
    		if(nums[i] != nums[cur_index]) {
    			cur_index++;
    			nums[cur_index] = nums[i];
    		}
    	}
    	
		return cur_index;   
    }

    /*
     * 时间复杂度：O(n)，假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
     * 空间复杂度：O(1)。
     */

    public static int removeDuplicates_2(int[] nums) {
        if (nums.length==0) {
			return 0;
		}
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
			if(nums[j]!=nums[i]) {
				nums[i+1] = nums[j];
				i++;
			}
		}
    	
		return i+1;   
    }
}
