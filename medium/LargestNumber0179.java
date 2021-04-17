package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LargestNumber0179 {
    public String largestNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        String res = "";
        if (numsString[0].equals("0")){
            return "0";
        }
        for(String num : numsString){
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        LargestNumber0179 largestNumber0179 = new LargestNumber0179();
        int[] nums = new int[]{0,0,0};
        System.out.println(largestNumber0179.largestNumber(nums));
    }
}
