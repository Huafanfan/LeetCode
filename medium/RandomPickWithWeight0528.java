package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/5 11:19
 */
public class RandomPickWithWeight0528 {
    int[] pre;
    int total;
    public RandomPickWithWeight0528(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i=1; i<w.length; i++){
            pre[i] = pre[i-1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    /**
     * 最小的满足 x≤pre[i] 的下标 i
     * @param x
     * @return
     */
    public int binarySearch(int x){
        int low = 0;
        int high = pre.length-1;
        while (low < high){
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}
