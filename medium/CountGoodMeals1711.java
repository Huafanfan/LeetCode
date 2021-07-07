package medium;

import java.util.*;

public class CountGoodMeals1711 {
    /**
     * 错误
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int delicious : deliciousness){
            map.put(delicious, map.getOrDefault(delicious, 0) + 1);
        }
        List<Integer> nums = new ArrayList<>(map.keySet());
        int res = 0;
        for (int i=0; i<nums.size(); i++){
            for (int j=i; j<nums.size(); j++){
                if (map.get(nums.get(j)) > 0){
                    long sum = nums.get(i) + nums.get(j);
                    if ((sum & (sum - 1)) == 0){
                        if (nums.get(i) == nums.get(j)){
                            res = (res + map.get(nums.get(i)) * (map.get(nums.get(i)) - 1) / 2) % 1000000007;
                        }
                        else {
                            res = (res + map.get(nums.get(i)) * map.get(nums.get(j))) % 1000000007;
                        }
                    }
                }
            }
        }
        return res;
    }
    public int countPairs2(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }


    public static void main(String[] args) {
        CountGoodMeals1711 countGoodMeals1711 = new CountGoodMeals1711();
        int[] deliciousness = new int[]{1,1,1,3,3,3,7};
        System.out.println(countGoodMeals1711.countPairs2(deliciousness));
    }
}
