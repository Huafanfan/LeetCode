package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/11/26 23:19
 */
public class CountWaysToBuildGoodStrings2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;
        int[] f = new int[high+1];
        f[0] = 1;
        int res = 0;
        for (int i=1; i<=high; i++){
            if (i >= one){
                f[i] = f[i-one];
            }
            if (i >= zero){
                f[i] = (f[i] + f[i-zero]) % MOD;
            }
            if (i >= low){
                res = (res + f[i]) % MOD;
            }
        }
        return res;
    }
}
