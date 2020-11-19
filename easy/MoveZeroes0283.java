package easy;

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

    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
