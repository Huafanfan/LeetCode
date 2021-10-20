package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/20 09:34
 */
public class MinimumMovesToEqualArrayElements0452 {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
