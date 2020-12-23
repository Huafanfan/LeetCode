package lcof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 15:13
 */
public class Lcof61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int countZero = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0){
                countZero++;
            }
            else if (i>0 && nums[i-1]!=0){
                while (countZero>0){
                    if (nums[i-1] + 1 == nums[i]){
                        break;
                    }else {
                        nums[i-1] ++;
                        countZero--;
                    }
                }
                if (nums[i-1] + 1 != nums[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            // 跳过大小王
            if(num == 0) {
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            // 若有重复，提前返回 false
            if(repeat.contains(num)) {
                return false;
            }
            // 添加此牌至 Set
            repeat.add(num);
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }

    public boolean isStraight3(int[] nums) {
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++) {
            // 统计大小王数量
            if(nums[i] == 0) {
                joker++;
            }
            // 若有重复，提前返回 false
            else if(nums[i] == nums[i + 1]) {
                return false;
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,2,9,7,10};
        Lcof61 lcof61 = new Lcof61();
        System.out.println(lcof61.isStraight(nums));
    }
}
