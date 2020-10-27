package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/27 09:59
 */
public class HowManyNumbersAreSmallerThantheCurrentNumber1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> sortList = new ArrayList<>();
        for (int num : nums){
            sortList.add(num);
        }
        Collections.sort(sortList);
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++ ){
            result[i] = sortList.indexOf(nums[i]);
        }
        return result;
    }

    public int[] smallerNumbersThanCurrentCount(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int num : nums){
            cnt[num]++;
        }
        for (int i=1 ; i<=100; i++){
            cnt[i] += cnt[i-1];
        }
        int[] res = new int[n];
        for (int i=0; i<n; i++){
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }
}
