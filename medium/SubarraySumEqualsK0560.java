package medium;


import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/4 10:27
 */
public class SubarraySumEqualsK0560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i=0; i<nums.length; i++){
            int sum = 0;
            //知道 [j,i] 子数组的和，就能 O(1) 推出 [j-1,i] 的和
            for (int j=i; j>=0; j--){
                sum += nums[j];
                if (sum==k){
                    count++;
                }
            }
            //下面这种方式需要 O(n^3) 的时间复杂度 顺着计算会有很多冗余计算
            //for (int j=0; j<=i; j++){
            //    int sumB = 0;
            //    for (int l=j; l<=i; l++){
            //        sumB += nums[l];
            //    }
            //    if (sumB==k){
            //        count++;
            //    }
            //}
        }
        return count;
    }

    public int subarraySumHash(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
