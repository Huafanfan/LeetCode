package byteDance;

import java.util.ArrayList;
import java.util.List;

public class FindK {
    //求数组中比左边元素都大同时比右边元素都小的元素，返回这些元素的索引
    //要求时间复杂度
    public List<Integer> find(int[] nums){
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];
        leftMax[0] = Integer.MIN_VALUE;
        rightMin[len - 1] = Integer.MAX_VALUE;
        for (int i=1; i<len; i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }
        for (int i=len-2; i>=0; i--){
            rightMin[i] = Math.min(rightMin[i+1], nums[i+1]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<len; i++){
            if (nums[i] > leftMax[i] && nums[i] < rightMin[i]){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindK findK = new FindK();
        int[] nums = new int[]{2,3,1,8,9,20,12};
        System.out.println(findK.find(nums));
    }
}
