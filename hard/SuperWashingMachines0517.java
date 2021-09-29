package hard;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/29 10:04
 */
public class SuperWashingMachines0517 {
    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        //sum这个变量，代表的是到目前这个下标（i）为止，0~i需要增加（减少）的总次数。
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
