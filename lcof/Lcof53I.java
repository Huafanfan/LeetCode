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
        if (nums.length < 1){
            return 0;
        }
        int leftIndex = binarySearch(nums, 0, nums.length-1, target, true);

        int rightIndex = binarySearch(nums, 0, nums.length - 1, target, false);
        if (leftIndex >=0 && leftIndex <= rightIndex && nums[leftIndex] == target && nums[rightIndex] == target){
            return rightIndex - leftIndex + 1;
        }
        return 0;

    }

    public int binarySearch(int[] nums, int left, int right, int target, boolean ifLeft){
        while (left<right){
            if (ifLeft){
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target){
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] <= target){
                    left = mid;
                }
                else {
                    right = mid - 1;
                }
            }

        }
        return left;
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

    public static void main(String[] args) {
        Lcof53I lcof53I = new Lcof53I();
        int[] nums = new int[]{1,2,3};
        System.out.println(lcof53I.search(nums, 2));
    }
}
