package medium;

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
        //需要当前数组中的最大最小值只需要<, 等于的时候表示找到
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
