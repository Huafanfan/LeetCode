package byteDance;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >=0 && nums[i] >= nums[i+1]){
            i--;
        }
        // 找到i < i + 1
        if (i >=0){
            int j = nums.length - 1;
            while (j >=0 && nums[j] <= nums[i]){
                j--;
            }
            // 找到第一个比i大的
            swap(nums, i , j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start){
        int left = start;
        int right = nums.length-1;
        while (left < right){
            swap(nums, left++, right--);
        }
    }
}
