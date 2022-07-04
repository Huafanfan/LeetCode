package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/4 11:12
 */
public class MinimumAbsoluteDifference1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;
        for (int i=1; i<arr.length; i++){
            List<Integer> nums = new ArrayList<>();
            int abs = arr[i] - arr[i-1];
            if (abs > minAbs){
                continue;
            }
            if (abs < minAbs){
                minAbs = abs;
                ans.clear();
            }
            nums.add(arr[i-1]);
            nums.add(arr[i]);
            ans.add(nums);
        }
        return ans;
    }
}
