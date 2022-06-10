package neetcode.binarysearch;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/10 10:24
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
