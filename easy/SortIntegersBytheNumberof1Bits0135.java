package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/6 09:20
 */
public class SortIntegersBytheNumberof1Bits0135 {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> count1s = new ArrayList<>();
        for (int num : arr){
            int count1 = count1(num);
            if (!count1s.contains(count1)){
                count1s.add(count1);
                List<Integer> nums = new ArrayList<>();
                nums.add(num);
                map.put(count1, nums);
            }
            else {
                List<Integer> nums = map.get(count1);
                nums.add(num);
                map.put(count1, nums);
            }
        }
        Collections.sort(count1s);
        int[] res = new int[arr.length];
        int index = 0;
        for (Integer count1 : count1s){
            List<Integer> nums = map.get(count1);
            Collections.sort(nums);
            for (int num : nums){
                res[index++] = num;
            }
        }
        return res;
    }

    public int count1(int num){
        int count = 0;
        while (num!=0){
            num &= num-1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        SortIntegersBytheNumberof1Bits0135 sortIntegersBytheNumberof1Bits0135 = new SortIntegersBytheNumberof1Bits0135();
        System.out.println(sortIntegersBytheNumberof1Bits0135.count1(1024));
    }
}
