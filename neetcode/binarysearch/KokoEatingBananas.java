package neetcode.binarysearch;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/13 10:51
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=Integer.MAX_VALUE;
        while (l < r){
            int m = l + (r -l)/2;
            if (success(m, h, piles)){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public boolean success(int speed, int h, int[] piles){
        int sum = 0;
        for (int pile : piles){
            sum += (pile - 1 + speed) / speed;
        }
        return sum <= h;
    }
}
