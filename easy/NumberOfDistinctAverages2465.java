package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yifan.zhangyf
 * @date 2022/11/26 23:11
 */
public class NumberOfDistinctAverages2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> s = new HashSet<>();
        for (int i=0, j=nums.length-1; i!=j; i++, j--){
            s.add(nums[i] + nums[j]);
        }
        return s.size();
    }
}
