package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 9:39
 */
public class SortColors0075 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int cur = 0;
        int p2 = nums.length-1;

        while (cur<=p2){
            if (nums[cur]==0){
                int temp = nums[cur];
                nums[cur++] = nums[p0];
                nums[p0++] = temp;
            }
            else if (nums[cur]==2){
                int temp = nums[cur];
                //这里是关键，cur不用++
                //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++
                nums[cur] = nums[p2];
                nums[p2--] = temp;
            }
            else {
                cur++;
            }
        }
    }
}
