package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/6 09:26
 */
public class BinarySearch0704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
