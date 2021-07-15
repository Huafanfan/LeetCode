package medium;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i=1; i<len; i++){
            arr[i] = Math.min(arr[i], arr[i-1] + 1);
        }
        return arr[len - 1];
    }

    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) {
                ++miss;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return n - miss;
    }
}
