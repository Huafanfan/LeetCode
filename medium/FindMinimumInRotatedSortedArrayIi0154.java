package medium;

public class FindMinimumInRotatedSortedArrayIi0154 {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length-1] > nums[0]){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }
            //无重复的情况下直接else就可以了，有重复的情况下需要把等于情况下拆分出来
            else if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
}
