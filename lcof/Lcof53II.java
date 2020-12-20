package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 10:06
 */
public class Lcof53II {
    /**
     * 100.00%
     * 56.80%
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if (nums[mid] == mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Lcof53II lcof53II = new Lcof53II();
        //int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        int[] nums = new int[]{0,1,3};
        System.out.println(lcof53II.missingNumber(nums));
    }
}
