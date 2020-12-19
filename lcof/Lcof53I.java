package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/19 15:41
 */
public class Lcof53I {
    /**
     * 100.00%
     * 85.10%
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right - left)/2;
        while (left<=right){
            if (nums[mid] == target){
                int count = 1;
                int increase = mid+1;
                int decrease = mid-1;
                while (increase<nums.length && nums[increase++] == target){
                    count++;
                }
                while (decrease>=0 && nums[decrease--] == target){
                    count++;
                }
                return count;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            mid = left + (right - left)/2;
        }
        return 0;
    }

    /**
     * 100.00%
     * 65.34%
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
