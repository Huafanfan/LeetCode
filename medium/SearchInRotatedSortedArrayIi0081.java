package medium;

public class SearchInRotatedSortedArrayIi0081 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        //寻找目标值，需要<=
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            }
            //这里必须加等号，等于表示有序
            else if (nums[mid]<=nums[r]){
                if (target> nums[mid] && target<= nums[r]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            else {
                if (target>= nums[l] && target< nums[mid]){
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayIi0081 searchInRotatedSortedArrayIi0081 = new SearchInRotatedSortedArrayIi0081();
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(searchInRotatedSortedArrayIi0081.search(nums, 13));
    }
}
