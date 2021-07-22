package byteDance;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int[] nums = new int[]{4,5,6,1,2,3};
        System.out.println(findMinimumInRotatedSortedArray.findMin(nums));
    }
}
