package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/15 15:51
 */
public class FindPeakElement0162 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
