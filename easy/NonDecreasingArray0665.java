package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/7 13:28
 */
public class NonDecreasingArray0665 {
    public static void main(String[] args) {
        NonDecreasingArray0665 nonDecreasingArray0665 = new NonDecreasingArray0665();
        int[] nums = new int[]{4,2,1};
        System.out.println(nonDecreasingArray0665.checkPossibility(nums));
    }
    public boolean checkPossibility(int[] nums) {
        for (int i=0; i<nums.length-1; i++){
            int x = nums[i], y = nums[i+1];
            if (y<x){
                nums[i] = y;
                if (isSort(nums)){
                    return true;
                }
                nums[i] = x;
                nums[i+1] = x;
                return isSort(nums);
            }
        }
        return true;
    }

    public boolean isSort(int[] nums){
        for (int i=1; i<nums.length; i++){
            if (nums[i-1]>nums[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkPossibility2(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
