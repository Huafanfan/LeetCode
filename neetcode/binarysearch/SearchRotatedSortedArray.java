package neetcode.binarysearch;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/13 11:20
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target){
                return mid;
            }
            // left sorted portion
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // right sorted portion
            else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid -1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
