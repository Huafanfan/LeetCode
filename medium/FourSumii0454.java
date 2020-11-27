package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/2 10:09
 */
public class FourSumii0454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int k : A) {
            for (int i : B) {
                //int sum = k + i;
                //if(map.containsKey(sum)) {
                //    map.put(sum,map.get(sum)+1);
                //} else {
                //    map.put(sum,1);
                //}
                map.put(k + i, map.getOrDefault(k + i, 0) + 1);
            }
        }
        for (int i : C){
            for (int j : D){
                int sum = -(i+j);
                if (map.containsKey(sum)){
                    result += map.get(sum);
                }
            }
        }
        return result;
    }
}
