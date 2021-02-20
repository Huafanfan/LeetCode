package easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray0697 {
    //输入：[1,2,2,3,1,4,2]
    //输出：6
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int len = nums.length;
        int degree = 0;
        int minLen = len;
        for (int i = 0; i < len; i++) {
            int[] arr = map.get(nums[i]);
            if (arr != null) {
                arr[0]++;
                arr[2] = i;
            } else {
                arr = new int[]{1,i,i};
                map.put(nums[i], arr);
            }
            int cnt = arr[0];
            if (cnt > degree){
                degree = cnt;
                minLen = arr[2] - arr[1] + 1;
            }
            else if (cnt == degree){
                minLen = Math.min(minLen, arr[2] - arr[1] +1);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        DegreeOfAnArray0697 degreeOfAnArray0697 = new DegreeOfAnArray0697();
        int[] nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(degreeOfAnArray0697.findShortestSubArray(nums));
    }
}
