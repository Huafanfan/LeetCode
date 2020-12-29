package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/29 10:52
 */
public class PatchingArray0330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        PatchingArray0330 patchingArray0330 = new PatchingArray0330();
        int[] nums = new int[]{1, 5, 10};
        System.out.println(patchingArray0330.minPatches(nums, 20));
    }
}
