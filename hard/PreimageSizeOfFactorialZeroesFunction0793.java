package hard;

/**
 * @author yifan.zhangyf
 * @date 2022/8/28 3:29 PM
 */
public class PreimageSizeOfFactorialZeroesFunction0793 {
    public int preimageSizeFZF(int k) {
        if (k <= 1){
            return 5;
        }
        return f(k) - f(k-1);
    }

    /**
     * f(k) 可得到非负整数中分解 5 个数为小于等于 k 的个数
     */
    public int f(int x){
        long l = 0, r = (long)1e10;
        while (l < r){
            long mid = l + r >> 1;
            if (getCnt(mid) <= x){
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int)l;
    }

    /**
     * 求有多少个0， 就是求可以分解出多少个5，因为2一定比5多
     */
    public long getCnt(long x){
        long ans = 0;
        while (x != 0){
            ans += x / 5;
            x /= 5;
        }
        return ans;
    }
}
