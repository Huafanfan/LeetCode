package medium.sort;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 9:39
 */
public class SortColors0075 {
    public static void main(String[] args) {
        SortColors0075 sortColors0075 = new SortColors0075();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors0075.sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
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

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    public void sortColors2(int[] nums) {
        if (nums.length == 0){
            return;
        }
        int r = 0;
        int w = 0;
        int b = 0;
        for (int num : nums){
            if (num == 0){
                nums[b] = 2;
                b++;
                nums[w] = 1;
                w++;
                nums[r] = 0;
                r++;
            }
            else if (num == 1){
                nums[b] = 2;
                b++;
                nums[w] = 1;
                w++;
            }
            else {
                b++;
            }
        }
    }
}
