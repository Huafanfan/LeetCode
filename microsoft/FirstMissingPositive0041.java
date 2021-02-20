package microsoft;

public class FirstMissingPositive0041 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean isHave1 = false;
        for (int num : nums){
            if (num == 1){
                isHave1 = true;
                break;
            }
        }
        if (!isHave1){
            return 1;
        }
        for (int i=0; i<len; i++){
            if (nums[i] < 1 || nums[i] > len){
                nums[i] = 1;
            }
        }
        for (int i=0; i<len; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for (int i=0; i<len; i++){
            if (nums[i] >0){
                return i + 1;
            }
        }
        return len + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
