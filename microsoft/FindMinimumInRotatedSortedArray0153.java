package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/15 15:05
 */
public class FindMinimumInRotatedSortedArray0153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;
        if (nums[r] > nums[0]) {
            return nums[0];
        }
        while (l < r){
            int mid = l + (r - l)/2;
            if (nums[mid]<nums[r]){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
