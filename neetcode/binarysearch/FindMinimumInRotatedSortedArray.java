package neetcode.binarysearch;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/14 15:57
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l <= r){
            if (nums[r] >= nums[l]){
                return nums[l];
            }
            int mid = l + (r - l)/2;
            if (nums[mid] >= nums[l]){
                l = mid+1;
            } else {
                r--;
            }
        }
        return nums[0];
    }
}
