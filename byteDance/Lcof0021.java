package byteDance;

public class Lcof0021 {
    public int[] exchange(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if ((nums[fast] & 1) == 1){
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        return nums;
    }

    public void swap(int[] num, int m, int n){
        int tmp = num[m];
        num[m] = num[n];
        num[n] = tmp;
    }
}
