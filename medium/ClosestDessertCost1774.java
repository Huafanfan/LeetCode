package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/4 11:44
 */
public class ClosestDessertCost1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int x = Arrays.stream(baseCosts).min().getAsInt();
        if (x >= target){
            return x;
        }
        boolean[] f = new boolean[target+1];
        // 此时x<target，可选择的范围[x, target, target + (target - x)]
        // 其他价格都不如直接返回x更接近与target
        int max = 2 * target - x;
        for (int base : baseCosts){
            if (base <= target){
                f[base] = true;
            } else {
                max = Math.min(max, base);
            }
        }
        for (int t : toppingCosts){
            for (int i=0; i<2; i++){
                for (int j=target; j>0; j--){
                    if (f[j] && j + t > target){
                        max = Math.min(max, j + t);
                    }
                    if (j - t > 0){
                        f[j] = f[j] | f[j-t];
                    }
                }
            }
        }
        for (int i=0; i<=max - target; i++){
            if (f[target - i]){
                return target - i;
            }
        }
        return max;
    }
}
