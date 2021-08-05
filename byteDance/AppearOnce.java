package byteDance;

public class AppearOnce {
    public int find(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + 1;
            if (mid > 0 && mid < nums.length - 1){
                if (nums[mid-1] != nums[mid] && nums[mid] != nums[mid + 1]){
                    return nums[mid];
                }
            }

        }
        return 0;
    }
}
