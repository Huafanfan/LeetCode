package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/7 17:53
 */
public class KokoEatingBananas0875 {
    /**
     * 二分查找
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int hight = Integer.MIN_VALUE;
        for (int pile : piles){
            hight = Math.max(hight, pile);
        }
        while (low < hight){
            int middle = (low + hight) >> 1;
            if (!possible(piles,H,middle)){
                low = middle + 1;
            }
            else {
                hight = middle;
            }
        }
        return low;
    }
    public boolean possible(int[] piles, int H, int K){
        int time = 0;
        for (int p : piles){
            //time += (p-1) / K + 1;
            //一个时间段内只能吃一堆香蕉
            time += (p + K -1)/K;
            // time += Math.ceil((double)p / K);
        }
        return time <= H;
    }
}
