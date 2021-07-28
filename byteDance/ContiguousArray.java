package byteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return 0;
        }
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<len; i++){
            if (nums[i] == 0){
                nums[i] = -1;
            }
            sum += nums[i];
            if (map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ContiguousArray contiguousArray = new ContiguousArray();
        int[] nums = new int[]{0,1,0};
        System.out.println(contiguousArray.findMaxLength(nums));
    }
}
