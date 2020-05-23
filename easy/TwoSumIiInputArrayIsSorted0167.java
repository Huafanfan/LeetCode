package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/6 17:32
 */
public class TwoSumIiInputArrayIsSorted0167 {
    /**
     * 双指针
     * 时间复杂度：O(n)。每个元素最多被访问一次，共有 n 个元素。
     * 空间复杂度：O(1)。只是用了两个指针。
     */
    public int[] twoSum(int[] numbers, int target) {
        int head = 0, tail=numbers.length-1;
        while(head<tail){
            if(numbers[head]+numbers[tail]==target){
                return new int[]{head,tail};
            }
            else if (numbers[head]+numbers[tail]<target){
                head++;
            }
            else{
                tail--;
            }
        }
        throw new RuntimeException("不存在");
    }
}
