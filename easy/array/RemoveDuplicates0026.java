package easy.array;

/**
 * @author alex
 *
 * 题目 #
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
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
        if(nums.length == 0){
            return 0;
        }
        int length = nums.length;
    	int j = 0;
    	for(int i=1;i<length;i++) {
    		if(nums[i] != nums[j]) {
    			nums[++j] = nums[i];
    		}
    	}
    	
		return j + 1;
    }

    /*
     * 时间复杂度：O(n)，假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
     * 空间复杂度：O(1)。
     */

    public static int removeDuplicates_2(int[] nums) {
        if (nums.length==0) {
			return 0;
		}
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
			if(nums[j]!=nums[j-1]) {
				nums[i] = nums[j];
				i++;
			}
		}
    	
		return i;
    }
}
