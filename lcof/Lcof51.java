package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/19 14:25
 */
public class Lcof51 {
    /**
     * 超时
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int dp = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i]>=max){
                if (nums[i] > max){
                    max = nums[i];
                }
            }
            else if (nums[i]<min){
                dp =  dp + i;
                min = nums[i];
            }
            else {
                int count = 0;
                for (int j=i-1; j>=0; j--){
                    if (nums[j]>nums[i]){
                        count++;
                    }
                }
                dp = dp + count;
            }
        }
        return dp;
    }

    /**
     * 77.18%
     * 89.61%
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        //这里的目的是不动原数组
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                //小于等于能保证归并排序稳定
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }



    public static void main(String[] args) {
        Lcof51 lcof51 = new Lcof51();
        int[] nums = new int[]{7,5,6,4};
        System.out.println(lcof51.reversePairs(nums));
    }
}
