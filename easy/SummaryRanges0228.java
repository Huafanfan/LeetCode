package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/10 10:10
 */
public class SummaryRanges0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0){
            return res;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i=1; i<n; i++){
            if (nums[i] - nums[i - 1] != 1) {
                StringBuilder builder = new StringBuilder().append(start);
                if (end != start) {
                    builder.append("->").append(end);
                }
                res.add(builder.toString());
                start = nums[i];
            }
            end = nums[i];
        }
        StringBuilder builder = new StringBuilder().append(start);
        if (end != start) {
            builder.append("->").append(end);
        }
        res.add(builder.toString());
        return res;
    }
}
